package com.banking.domain;

public interface Depositable {
    AccountBalance deposit(long amount);
}