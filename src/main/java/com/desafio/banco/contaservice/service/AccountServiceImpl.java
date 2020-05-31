package com.desafio.banco.contaservice.service;

import com.desafio.banco.contaservice.common.AccountType;
import com.desafio.banco.contaservice.common.UserType;
import com.desafio.banco.contaservice.dto.UserDTO;
import com.desafio.banco.contaservice.model.Account;
import com.desafio.banco.contaservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository repository;

    @Autowired
    private Environment env;

    @Value("${account.agency}")
    private String agency;

    @Override
    public Account createAccountToUser(UserDTO user) {
        Account account = new Account();
        account.setAgency(Long.valueOf(this.agency));
        account.setUserId(user.getDocument());
        account.setType(getAccountType(user.getType()));
        setLimitsToAccount(account, user.getScore());

        return repository.save(account);
    }

    @Override
    public List<Account> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Account> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Account> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Account update(Account account) {
        return repository.save(account);
    }

    @Override
    public Long delete(Account account) {
        repository.delete(account);

        return account.getNumber();
    }

    @Override
    public Long delete(Long id) {
        return delete(get(id).orElseThrow(() -> new RuntimeException("Account not found.")));
    }

    private AccountType getAccountType(UserType userType) {
        return userType.equals(UserType.PJ) ? AccountType.BUSSINESS : AccountType.CURRENT;
    }

    private void setLimitsToAccount(Account account, Integer userScore) {
        BigDecimal accountLimit = new BigDecimal(env.getProperty("account.limit.score." + userScore));
        account.setAccountLimit(accountLimit);

        BigDecimal creditCardLimit = new BigDecimal(env.getProperty("creditcard.limit.score." + userScore));
        account.setCreditCardLimit(creditCardLimit);
    }

}
