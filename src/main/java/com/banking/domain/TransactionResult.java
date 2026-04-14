package com.banking.domain;

public sealed interface TransactionResult
        permits TransactionSuccess, TransactionFailure {}