package com.banking.domain;

public record AccountBalance(String accountId, double availableBalance,
                             double blockedAmount, String currency) {
    public AccountBalance {
        if(accountId == null || accountId.isBlank()) throw new IllegalArgumentException("Account ID required");
        if(availableBalance < 0) throw new IllegalArgumentException("Available balance cannot be negative");
        if(blockedAmount < 0) throw new IllegalArgumentException("Blocked amount cannot be negative");
        if(currency == null || currency.isBlank()) throw new IllegalArgumentException("Currency required");
    }

    public double totalBalance() {
        return availableBalance + blockedAmount;
    }
}