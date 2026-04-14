package com.banking.domain;

public sealed interface TransactionFailure extends TransactionResult
        permits InsufficientFundsFailure, ReceiverNotFoundFailure, ConnectionFailure {
}