package com.banking.service;

public class PaymentCommission implements CommissionStrategy {
    public long calculate(long amount) { return amount * 1 / 100; }
}