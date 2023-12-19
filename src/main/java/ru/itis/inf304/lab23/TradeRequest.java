package ru.itis.inf304.lab23;

import java.math.BigDecimal;

public class TradeRequest {

    private final int amount;
    private final BigDecimal total;

    public TradeRequest(int amount, BigDecimal total) throws InvalidTotalException, InvalidAmountException, InvalidTotalScaleException {
        validate(amount, total);
        this.amount = amount;
        this.total = total;
    }

    private void validate(int amount, BigDecimal total) throws InvalidAmountException, InvalidTotalException, InvalidTotalScaleException {
        if (amount <= 0)
            throw new InvalidAmountException();
        if (total.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidTotalException("Total should be greater than 0");
        if (total.scale() > 2)
            throw new InvalidTotalScaleException(total.scale(), 2);
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
