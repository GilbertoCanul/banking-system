package com.banking.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Transaction(String transactionId, String senderAccountId, String receiverAccountId, long amount, TransactionType transactionType, LocalDateTime timestamp) {
    public Transaction {
        if(transactionId == null) throw new IllegalArgumentException("Transaction ID required");
        if(senderAccountId == null || senderAccountId.isBlank()) throw new IllegalArgumentException("Sender account ID required");
        if(receiverAccountId == null || receiverAccountId.isBlank()) throw new IllegalArgumentException("Receiver account ID required");
        if(amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        if(transactionType == null) throw new IllegalArgumentException("Transaction type required");
        if(timestamp == null) throw new IllegalArgumentException("Timestamp required");
    }

    // Timestamp is always generated here, not from the exterior
    public static Transaction of(String senderAccountId, String receiverAccountId, long amount, TransactionType transactionType) {
        return new Transaction(UUID.randomUUID().toString(), senderAccountId, receiverAccountId, amount, transactionType, LocalDateTime.now());
    }
}