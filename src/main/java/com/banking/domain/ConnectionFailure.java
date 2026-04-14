package com.banking.domain;

public record ConnectionFailure(String serviceName, int timeoutSeconds)
        implements TransactionFailure {
}
