package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank.model.BankAccount;

public interface BankRepo extends JpaRepository<BankAccount, Long> {
}
