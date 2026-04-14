package com.banking.service;

public interface CommissionStrategy {
    long calculate(long amount);
}