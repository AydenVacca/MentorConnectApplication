package com.webapp.mentorconnect2.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AccountTest {
    private Account acc;

    @BeforeEach
    void setUp(){
        acc = new Account();
    }

    @Test
    void testConstructor(){
        acc = new Account("Willy", "Wonka", "Mentor");
        assertNotNull(acc);
        assertEquals("Willy", acc.getUsername());
        assertEquals("Wonka", acc.getPassword());
    }

    @Test
    void testSetAndGet(){
        acc.setConfirmPassword("Wonka");
        acc.setEmail("Willy@ilstu.edu");
        acc.setPassword("Wonka");
        acc.setUsername("Willy");

        assertEquals("Wonka", acc.getConfirmPassword());
        assertEquals("Willy@ilstu.edu", acc.getEmail());
        assertEquals("Wonka", acc.getPassword());
        assertEquals("Willy", acc.getUsername());
    }

    

}
