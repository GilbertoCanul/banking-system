package com.banking.domain;

public record ReceiverNotFoundFailure(String receiverAccountId)
        implements TransactionFailure {
    public String getSummary() {
        return "Failed: receiver account " + receiverAccountId + " not found";
    }
}
