package com.sacavix.ca.moneytransfers.application.port.out;

import com.sacavix.ca.moneytransfers.domain.Account;

public interface LoadAccountPort {
    Account load(Long id);
}
