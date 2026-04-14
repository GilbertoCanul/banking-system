package com.banking.domain;

public record Account(String accountHolder, String accountID, AccountType accountType, AccountBalance accountBalance) {
    public Account {
        if(accountHolder == null || accountHolder.isBlank()) throw new IllegalArgumentException("Account holder required");
        if(accountID == null || accountID.isBlank()) throw new IllegalArgumentException("Account ID required");
        if(accountType == null) throw new IllegalArgumentException("Account type required");
        if(accountBalance == null) throw new IllegalArgumentException("Account balance required");
    }
}