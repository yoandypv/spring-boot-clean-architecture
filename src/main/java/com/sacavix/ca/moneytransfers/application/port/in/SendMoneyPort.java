package com.sacavix.ca.moneytransfers.application.port.in;

public interface SendMoneyPort {
    public boolean send(SendMoneyCommand command);
}
