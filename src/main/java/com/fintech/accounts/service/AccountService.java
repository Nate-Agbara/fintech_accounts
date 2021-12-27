package com.fintech.accounts.service;

import com.fintech.accounts.model.Account;

import java.util.Optional;

public interface AccountService {

    void createAccount(Account account);

    Optional<Account> findByCustomerId(long id);

    Account findLastAccountNo();
}
