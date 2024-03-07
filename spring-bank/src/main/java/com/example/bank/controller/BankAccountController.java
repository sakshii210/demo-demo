package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.BankAccount;
import com.example.bank.repository.BankRepo;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    @Autowired
    private BankRepo accountRepository;

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return accountRepository.save(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable Long id) {
        BankAccount account = accountRepository.findById(id)
                .orElse(null);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
