package com.desafio.banco.contaservice.model;

import com.desafio.banco.contaservice.common.AccountType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@SequenceGenerator(name = "account_seq", sequenceName="ACCOUNT_SEQ", initialValue = 100000, allocationSize = 6)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    private Long number;

    @NotNull
    private Long userId;

    @NotNull
    private Long agency;

    @NotNull
    private BigDecimal accountLimit;

    @NotNull
    private BigDecimal creditCardLimit;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType type;

}
