package com.banking.domain;

public record TransactionSuccess(String transactionId, long amount)
        implements TransactionResult {
}