package com.fintech.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *@author: Nathan
 *
 */

@Data
@AllArgsConstructor
public class AccountResponse {
    private String accountName;
    private long customerID;
    private long accountNo;
}
