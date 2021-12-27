package com.fintech.accounts.validator;

import com.fintech.accounts.dto.AccountDto;
import org.springframework.stereotype.Component;

/**
 *@author: Nathan
 *
 */
@Component
public class AccountValidator {

    public String validate(AccountDto accountDto) throws AccountValidationException{
        if(accountDto.getFirstName() == null ||accountDto.getFirstName() == "" || accountDto.getFirstName().equals("")){
            throw new AccountValidationException("firstname must not be null");
        }
        return accountDto.getFirstName();
    }
}
