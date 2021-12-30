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
@ApiModel(description = "Account ErrorResponse model")
public class ArgumentsErrorResponseDto {

    @ApiModelProperty(notes = "Error message", name = "message", required = true, value = "invalid amount")
    private String message;

    @ApiModelProperty(notes = "error status", name = "accountNo", required = true, value = "400")
    private String status;

    @ApiModelProperty(notes = "error code", name = "accountNo", required = true, value = "1000")
    private int code;
}
