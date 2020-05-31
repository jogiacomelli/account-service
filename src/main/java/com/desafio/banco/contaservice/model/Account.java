package com.desafio.banco.contaservice.model;

import com.desafio.banco.contaservice.common.AccountType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
