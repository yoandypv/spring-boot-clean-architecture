package com.sacavix.ca.moneytransfers.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMoneyCommand {
    private Long sourceId;
    private Long targetId;
    private BigDecimal amount;
}
