package com.banking.domain;

public record InvalidTransactionFailure(String reason)
        implements TransactionFailure {}