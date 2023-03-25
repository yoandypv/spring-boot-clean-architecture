package com.sacavix.ca.moneytransfers.adapter.out.persistence;

import com.sacavix.ca.moneytransfers.domain.Account;

public class AccountMapper {

    public static Account entityToDomain(AccountEntity accountEntity) {
        Account account = new Account();
        account.setId(accountEntity.getId());
        account.setAmount(accountEntity.getAmount());
        return account;
    }

    public static AccountEntity domainToEntity(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(account.getId());
        accountEntity.setAmount(account.getAmount());
        return accountEntity;
    }
}
