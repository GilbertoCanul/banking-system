package com.banking.domain;

public sealed interface TransactionFailure extends TransactionResult
        permits InvalidTransactionFailure, InsufficientFundsFailure, ReceiverNotFoundFailure, ConnectionFailure {
}