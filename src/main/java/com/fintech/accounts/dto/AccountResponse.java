package com.fintech.accounts.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *@author: Nathan
 *
 */

@Data
@AllArgsConstructor
public class AccountResponse {

    @ApiModelProperty(notes = "full accountName of the user", name = "accountName", required = true, value = "John Nate Doe")
    private String accountName;

    @ApiModelProperty(notes = "CustomerID of the user", name = "customerID", required = true, value = "0000000")
    private long customerID;

    @ApiModelProperty(notes = "Account number of the user", name = "accountNo", required = true, value = "0000000000")
    private long accountNo;
}
