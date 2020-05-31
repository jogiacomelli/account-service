package com.desafio.banco.contaservice.controller;

import com.desafio.banco.contaservice.dto.UserDTO;
import com.desafio.banco.contaservice.model.Account;
import com.desafio.banco.contaservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody UserDTO user) {
        return ResponseEntity.ok().body(service.createAccountToUser(user));
    }

    @GetMapping("/{number}")
    public ResponseEntity<Account> get(@PathVariable Long number) {
        return ResponseEntity.ok().body(service.get(number)
                .orElseThrow(() -> new RuntimeException("Account not found")));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Account> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok().body(service.getByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Account not found")));
    }
}
