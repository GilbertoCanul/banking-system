package com.banking.domain;

public class CheckingAccount implements Depositable, Withdrawable, Transferable {
    private AccountBalance balance;

    public CheckingAccount(AccountBalance balance) {
        this.balance = balance;
    }

    @Override
    public AccountBalance deposit(long amount) {
        balance = new AccountBalance(
                balance.accountId(),
                balance.availableBalance() + amount,
                balance.blockedAmount(),
                balance.currency()
        );

        return balance;
    }

    @Override
    public AccountBalance withdraw(long amount) {
        if(amount > balance.availableBalance()) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal");
        }

        balance = new AccountBalance(
                balance.accountId(),
                balance.availableBalance() - amount,
                balance.blockedAmount(),
                balance.currency()
        );

        return balance;
    }

    @Override
    public AccountBalance transfer(String receiverAccountId, long amount) {
        if(amount > balance.availableBalance()) {
            throw new IllegalArgumentException("Insufficient funds for transfer");
        }

        balance = new AccountBalance(
                balance.accountId(),
                balance.availableBalance() - amount,
                balance.blockedAmount(),
                balance.currency()
        );

        return balance;
    }
}