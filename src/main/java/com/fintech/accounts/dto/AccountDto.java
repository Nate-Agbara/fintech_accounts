package com.fintech.accounts.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 *@author: Nathan
 *
 */

@Data
@ApiModel(description = "Account Create/Update Request model")
public class AccountDto {

    @NotEmpty(message = "firstname cannot be empty")
    @ApiModelProperty(notes = "FirstName of the user", name = "firstName", required = true, value = "John")
    private String firstName;

    @ApiModelProperty(notes = "OtherName of the user", name = "otherName", required = true, value = "Nate")
    private String otherNames;

    @NotEmpty(message = "lastname cannot be empty")
    @ApiModelProperty(notes = "LastName of the user", name = "lastName", required = true, value = "Doe")
    private String lastName;

    @NotEmpty(message = "address cannot be empty")
    @ApiModelProperty(notes = "address of the user", name = "address", required = true, value = "VI, Lagos")
    private String address;

    @NotEmpty(message = "gender cannot be empty")
    @ApiModelProperty(notes = "gender of the user", name = "gender", required = true, value = "Male")
    private String gender;

    @NotEmpty(message = "phone cannot be empty")
    @ApiModelProperty(notes = "phoneNumber of the user", name = "phone", required = true, value = "234800000000")
    private String phone;

    @NotEmpty(message = "email cannot be empty")
    @ApiModelProperty(notes = "email of the user", name = "email", required = true, value = "JohnDoe@example.com")
    private String email;

    @NotEmpty(message = "customertype cannot be empty")
    @ApiModelProperty(notes = "New or existing customer/user", name = "customertype", required = true, value = "New")
    private String customertype;

    @ApiModelProperty(notes = "customerId of user", name = "customerId", required = true, value = "New")
    private long customerId;

    @ApiModelProperty(notes = "accountNumber of user", name = "accountNo", required = true, value = "New")
    private long accountNo;

}
