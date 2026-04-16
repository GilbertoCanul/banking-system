package com.banking.domain;

public record InsufficientFundsFailure(Long availableAmount, long requestedAmount)
        implements TransactionFailure {
    public String getSummary() {
        return "Failed: insufficient funds. Available: " + availableAmount + ", requested: " + requestedAmount;
    }
}
