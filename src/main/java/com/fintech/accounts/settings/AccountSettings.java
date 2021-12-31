package com.fintech.accounts.settings;

import com.fintech.accounts.model.Account;
import com.fintech.accounts.repository.AccountsRepository;
import com.fintech.accounts.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: Nathan
 */
@Slf4j
public class AccountSettings {

    /**
     * Generate account number for users
     * @param lastAccount keeps track of the last created account
     */

    public long createAccount(long lastAccount){
        long newAccount = 0000000000;
        long stop = 2000000000;
        if (lastAccount < stop)
            newAccount = lastAccount+1;
        else
            log.info("we have exhausted allocated account numbers");
        return newAccount;
    }

    /**
     * the assumption is that one user can have multiple accounts.
     * So one customer ID is mapped to different accounts
     *
     * @param lastCustomer tracks the last created customer ID
     * @param newOrExistingCustomer generate ID if the user is a first time user.
     *                              Handles only new users for now.
     */

    public long createCustomer(long lastCustomer, String newOrExistingCustomer){
        long newCustomer = 0000000;
        long stop = 2000000;
        if(!newOrExistingCustomer.equalsIgnoreCase("Existing")) {
            if (lastCustomer < stop)
                newCustomer = lastCustomer + 1;
            else
                log.info("we have exhausted allocated customer numbers");
        }
        return newCustomer;
    }
}
