package com.banking.domain;

public record Account(String accountHolder, String accountNumber, String accountType, AccountBalance accountBalance) {
    public Account {
        if(accountHolder == null || accountHolder.isBlank()) throw new IllegalArgumentException("Account holder required");
        if(accountNumber == null || accountNumber.isBlank()) throw new IllegalArgumentException("Account number required");
        if(accountType == null) throw new IllegalArgumentException("Account type required");
        if(accountBalance == null) throw new IllegalArgumentException("Account balance required");
    }
}