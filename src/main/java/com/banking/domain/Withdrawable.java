package com.banking.domain;

public interface Withdrawable {
    AccountBalance withdraw(long amount);
}