package com.banking.service;

public class TransferCommission implements CommissionStrategy {
    public long calculate(long amount) { return amount * 2 / 100; }
}