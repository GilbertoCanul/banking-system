package com.banking.domain;

public record TransactionSuccess(String transactionId, Long amount)
        implements TransactionResult {
}