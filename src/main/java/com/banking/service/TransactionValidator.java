package com.banking.service;

import com.banking.domain.*;

import java.util.UUID;

public class TransactionValidator {
    public TransactionResult validate(Transaction transaction, Account senderAccount) {
        if(transaction.amount() <= 0) {
            return new InvalidTransactionFailure("Amount not valid");
        } else if(senderAccount.accountBalance().availableBalance() < transaction.amount()) {
            return new InsufficientFundsFailure(senderAccount.accountBalance().availableBalance(), transaction.amount());
        } else {
            return new TransactionSuccess(UUID.randomUUID().toString(), transaction.amount());
        }
    }
}
