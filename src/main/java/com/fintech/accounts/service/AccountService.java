package com.fintech.accounts.service;

import com.fintech.accounts.model.Account;

import java.util.Optional;

public interface AccountService {

    void createAccount(Account account);

    Account findLastAccountNo();

    Optional<Account> findByAccountNo(long accountNo);

    void updateAccount(String address, String email, String firstname, String gentder,
                       String lastname, String othernames, String phone, long accout_no);
}
