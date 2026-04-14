package com.banking.service;

import com.banking.domain.Transaction;

public class CommissionCalculator {
    public long calculate(Transaction transaction, CommissionStrategy strategy) {
        return strategy.calculate(transaction.amount());
    }
}
