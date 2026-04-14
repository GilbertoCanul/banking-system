package com.banking.domain;

public record ReceiverNotFoundFailure(String receiverAccountId)
        implements TransactionFailure {
}
