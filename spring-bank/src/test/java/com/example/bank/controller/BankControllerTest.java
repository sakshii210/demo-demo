package com.example.bank.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.example.bank.model.BankAccount;

@SpringBootTest
public class BankControllerTest {

	@Autowired
    private BankAccountController bankAccountController;

    @Test
    public void testCreateAccount() {
        BankAccount account = new BankAccount();
        account.setId(101L);
        account.setAccountNumber("1234567890");
        account.setIfscCode("UNI0934");
        account.setBalance(1000);

        BankAccount savedAccount = bankAccountController.createAccount(account);

        assertNotNull(savedAccount);
        assertNotNull(savedAccount.getId());
        assertEquals("1234567890", savedAccount.getAccountNumber());
        assertEquals(1000, savedAccount.getBalance());
    }
    @Test
    public void testGetAllAccounts() {
        // Assuming there are some accounts already present in the system
        List<BankAccount> accounts = bankAccountController.getAllAccounts();

        assertNotNull(accounts);
        assertTrue(accounts.size() > 0);
    }

    @Test
    public void testGetAccountById() {
        // Assuming there's an account with id 1
        Long accountId = 1L;

        ResponseEntity<BankAccount> response = bankAccountController.getAccountById(accountId);

        //assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(accountId, response.getBody().getId());
    }
}