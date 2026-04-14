package com.banking.domain;

public record InsufficientFundsFailure(Long availableAmount, long requestedAmount)
        implements TransactionFailure {
}
