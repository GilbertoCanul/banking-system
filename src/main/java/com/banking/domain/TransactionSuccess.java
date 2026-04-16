package com.banking.domain;

public record TransactionSuccess(String transactionId, long amount)
        implements TransactionResult {
    public String getSummary() {
        return "Success: transaction " + transactionId + " for amount " + amount;
    }
}