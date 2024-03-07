package com.example.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {
	@Id
    private Long id;
    private String accountNumber;
    private String ifscCode;
    private double balance;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
    

}
