package com.sacavix.ca.moneytransfers.application.service;

import com.sacavix.ca.moneytransfers.application.port.in.SendMoneyCommand;
import com.sacavix.ca.moneytransfers.application.port.in.SendMoneyPort;
import com.sacavix.ca.moneytransfers.application.port.out.LoadAccountPort;
import com.sacavix.ca.moneytransfers.application.port.out.UpdateAccountPort;
import com.sacavix.ca.moneytransfers.common.UseCase;
import com.sacavix.ca.moneytransfers.domain.Account;

import javax.transaction.Transactional;

@UseCase
public class SendMoneyService implements SendMoneyPort {

    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;

    public SendMoneyService(LoadAccountPort loadAccountPort, UpdateAccountPort updateAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.updateAccountPort = updateAccountPort;
    }

    @Transactional
    @Override
    public boolean send(SendMoneyCommand command) {

        Account source = loadAccountPort.load(command.getSourceId());
        Account target = loadAccountPort.load(command.getTargetId());

        if(!source.isBalanceGreaterThan(command.getAmount())) {
            throw new RuntimeException("Source account not have enough balance amount ... ");
        }

        target.plus(command.getAmount());
        source.subtract(command.getAmount());

        updateAccountPort.update(source);
        updateAccountPort.update(target);

        return true;
    }
}
