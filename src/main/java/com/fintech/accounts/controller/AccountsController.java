package com.fintech.accounts.controller;

import com.fintech.accounts.dto.AccountDto;
import com.fintech.accounts.dto.AccountResponse;
//import com.fintech.accounts.mapper.AccountMapper;
import com.fintech.accounts.model.Account;
import com.fintech.accounts.model.AccountStatus;
import com.fintech.accounts.service.AccountService;
import com.fintech.accounts.settings.AccountSettings;
import com.fintech.accounts.validator.AccountValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Random;

/**
 *@author: Nathan
 *
 */

@Slf4j
@RestController
public class AccountsController {

    @Autowired
    private AccountService accountService;

//    @Autowired
//    private AccountMapper accountMapper;

    @PostMapping("/CreateAccount")
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody AccountDto accountdto) {
        Account account1 = accountService.findLastAccountNo();
        long customerId = new AccountSettings().createCustomer(account1.getCustomerID(),
                accountdto.getCustomertype());
        long accountNo = new AccountSettings().createAccount(account1.getAccountNo());
        Account account = new Account();
        if(accountdto.getFirstName() == null ||accountdto.getFirstName() == "" || accountdto.getFirstName().equals("")){
            throw new AccountValidationException("Name is mandatory");
        }
        account.setCustomerID(customerId);
        account.setFirstName(accountdto.getFirstName());
        account.setLastName(accountdto.getLastName());
        account.setOtherNames(accountdto.getOtherNames());
        account.setAddress(accountdto.getAddress());
        account.setGender(accountdto.getGender());
        account.setPhone(accountdto.getPhone());
        account.setEmail(accountdto.getEmail());
        account.setAccountNo(accountNo);
        account.setBalance(BigDecimal.ZERO);
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setEmailNotification(false);
        account.setSmsNotification(false);
        log.info("Request: "+accountdto.toString());
        try {
            accountService.createAccount(account);
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }

        return new ResponseEntity<>(new AccountResponse(accountdto.getFirstName()+" "+
                accountdto.getOtherNames()+" "+accountdto.getLastName(),
                customerId, accountNo),HttpStatus.CREATED);

    }


}
