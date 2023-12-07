package com.webapp.mentorconnect2.repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.mentorconnect2.models.Account;

public interface AccountService extends CrudRepository<Account, Long> {

    Account findByUsername(String username);
    
}
