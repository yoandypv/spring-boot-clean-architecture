package com.sacavix.ca.moneytransfers.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private Long id;
    private BigDecimal amount;

    public Boolean isBalanceGreaterThan(BigDecimal anotherAmount) {
        return this.amount.compareTo(anotherAmount) >= 0;
    }
    public void plus(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

    public void subtract(BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
    }

}
