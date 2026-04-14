package com.banking.domain;

public record InsufficientFundsFailure(Long availableAmount, Long requestedAmount)
        implements TransactionFailure {
}
