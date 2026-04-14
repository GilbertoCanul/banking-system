package com.banking.domain;

public enum TransactionType {
    // Inflows (Credits/Increases to balance)
    DEPOSIT(1),
    TRANSFER_IN(1),
    REFUND(1),

    // Outflows (Debits/Decreases to balance)
    WITHDRAWAL(-1),
    TRANSFER_OUT(-1),
    PAYMENT(-1),
    FEE(-1),

    // Miscellaneous / Administrative
    ADJUSTMENT_CREDIT(1),
    ADJUSTMENT_DEBIT(-1);

    private final int multiplier;

    TransactionType(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    /**
     * Calculates the signed amount based on the transaction type.
     * @param amount The absolute value of the transaction (in cents/minor units).
     * @return The amount with the correct sign applied.
     */
    public long getFinalAmount(long amount) {
        return amount * multiplier;
    }
}