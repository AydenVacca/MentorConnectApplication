package com.webapp.mentorconnect2.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.webapp.mentorconnect2.models.Account;

@DataJpaTest
public class AccountServiceTest {
    
    @Autowired
    private AccountService accountDB;

    private Account testAccount;
    
    @BeforeEach
    void setup(){
        testAccount = new Account();
        testAccount.setConfirmPassword("Dale");
        testAccount.setEmail("BigDale@ilstu.edu");
        testAccount.setPassword("HotDog");
        testAccount.setUsername("HotDog");
    }

    @Test
    void saveTest(){
        Account savedAccount = accountDB.save(testAccount);
        assertNotNull(savedAccount.getUserId());
    }

    @Test
    void findById(){
        Account savedAccount = accountDB.save(testAccount);
        Optional<Account> foundAcc = accountDB.findById(savedAccount.getUserId());
        assertEquals(savedAccount, foundAcc.get());
    }

    @Test
    void findAll(){
        accountDB.save(testAccount);
        List<Account> accounts = (List<Account>) accountDB.findAll();
        assertEquals(1, accounts.size());
    }

    @Test
    void delete(){
        Account savedAccount = accountDB.save(testAccount);
        accountDB.deleteById(savedAccount.getUserId());
        Optional<Account> foundAcc = accountDB.findById(savedAccount.getUserId());
        assertEquals(false, foundAcc.isPresent());
    }
}
