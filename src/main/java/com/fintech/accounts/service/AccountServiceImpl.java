package com.fintech.accounts.service;

import com.fintech.accounts.model.Account;
import com.fintech.accounts.repository.AccountsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *@author: Nathan
 *
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private AccountsRepository accountsRepository;

    public AccountServiceImpl(){}

    @Autowired
    public AccountServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public void createAccount( Account account){
        try {
            accountsRepository.save(account);
        }catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
        }

    }

    public Optional<Account> findByCustomerId(long id){
        Optional<Account> account = accountsRepository.findByCustomerId(id);
        return account;
    }

    public Account findLastAccountNo() {
        return  accountsRepository.findLastAccountNo();
    }
}
