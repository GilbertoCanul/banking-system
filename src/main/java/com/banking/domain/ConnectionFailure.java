package com.banking.domain;

public record ConnectionFailure(String serviceName, int timeoutSeconds)
        implements TransactionFailure {
    public String getSummary() {
        return "Failed: connection error in service " + serviceName;
    }
}
