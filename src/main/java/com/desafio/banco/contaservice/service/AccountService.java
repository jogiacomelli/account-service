package com.desafio.banco.contaservice.service;

import com.desafio.banco.contaservice.dto.UserDTO;
import com.desafio.banco.contaservice.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account createAccountToUser(UserDTO user);

    List<Account> getAll();

    Optional<Account> get(Long id);

    Optional<Account> getByUserId(Long userId);

    Account update(Account user);

    Long delete(Account user);

    Long delete(Long id);
}
