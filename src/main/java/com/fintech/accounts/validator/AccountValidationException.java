package com.fintech.accounts.validator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *@author: Nathan
 *
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountValidationException extends RuntimeException {
    public AccountValidationException(String message) {
        super(message);
    }

}
