package com.banking.service;

import com.banking.domain.*;

import java.util.*;

public class TransactionService {
    public List<Transaction> getHighValueTransactions(List<Transaction> transactions, long threshold) {
        return transactions.stream()
                .filter(t -> t.amount() > threshold)
                .sorted(Comparator.comparing(Transaction::amount).reversed())
                .toList();
    }

    public long getTotalByType(List<Transaction> transactions, TransactionType transactionType) {
        return transactions.stream()
                .filter(t -> t.transactionType() == transactionType)
                .mapToLong(Transaction::amount)
                .sum();
    }

    public List<String> getSuccessfulTransactionIds(Map<Transaction, TransactionResult> transactions) {
        return transactions.entrySet().stream()
                .filter(entry -> entry.getValue() instanceof TransactionSuccess)
                .map(entry -> entry.getKey().transactionId())
                .toList();
    }

    public Optional<Transaction> findFirstHighValueTransaction(List<Transaction> transactions, long threshold) {
        return transactions.stream()
                .filter(t -> t.amount() > threshold)
                .findFirst();
    }

    public String getSenderAccountId(List<Transaction> transactions, long threshold) {
        return findFirstHighValueTransaction(transactions, threshold)
                .map(Transaction::senderAccountId)
                .orElse("No high value transaction found");
    }
}