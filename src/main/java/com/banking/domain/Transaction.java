package com.banking.domain;

import java.time.LocalDateTime;

public record Transaction(String senderAccountID, String receiverAccountID, Long amount, TransactionType transactionType, LocalDateTime timestamp) {
    public Transaction {
        if(senderAccountID == null || senderAccountID.isBlank()) throw new IllegalArgumentException("Sender account ID required");
        if(receiverAccountID == null || receiverAccountID.isBlank()) throw new IllegalArgumentException("Receiver account ID required");
        if(amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        if(transactionType == null) throw new IllegalArgumentException("Transaction type required");
        if(timestamp == null) throw new IllegalArgumentException("Timestamp required");
    }

    // Timestamp is always generated here, not from the exterior
    public static Transaction of(String senderAccountId, String receiverAccountId, Long amount, TransactionType transactionType) {
        return new Transaction(senderAccountId, receiverAccountId, amount, transactionType, LocalDateTime.now());
    }
}