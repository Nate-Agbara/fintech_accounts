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

    public long createAccount(long lastAccount){
        long newAccount = 0000000000;
        long stop = 2000000000;
        if (lastAccount < stop)
            newAccount = lastAccount+1;
        else
            log.info("we have exhausted allocated account numbers");
        return newAccount;
    }

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
