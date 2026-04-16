package com.banking.domain;

public record InvalidTransactionFailure(String reason)
        implements TransactionFailure {
    public String getSummary() {
        return "Failed: invalid transaction. " + reason;
    }
}