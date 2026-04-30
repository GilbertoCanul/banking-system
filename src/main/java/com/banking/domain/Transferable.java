package com.banking.domain;

public interface Transferable {
    AccountBalance transfer(String receiverAccountId, long amount);
}