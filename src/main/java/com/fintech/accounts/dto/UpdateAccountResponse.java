package com.fintech.accounts.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Nathan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Account Update Response model")
public class UpdateAccountResponse {

    @ApiModelProperty(notes = "update account response message", name = "message", required = true, value = "Updated successfully")
    private String message;
}
