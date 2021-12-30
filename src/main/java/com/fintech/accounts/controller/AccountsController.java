package com.fintech.accounts.controller;

import com.fintech.accounts.dto.AccountDto;
import com.fintech.accounts.dto.AccountResponse;
//import com.fintech.accounts.mapper.AccountMapper;
import com.fintech.accounts.dto.ArgumentsErrorResponseDto;
import com.fintech.accounts.dto.UpdateAccountResponse;
import com.fintech.accounts.model.Account;
import com.fintech.accounts.model.AccountStatus;
import com.fintech.accounts.service.AccountService;
import com.fintech.accounts.settings.AccountSettings;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

/**
 *@author: Nathan
 *
 */
@ApiOperation(value = "/account/vi/users", tags = "Account Controller")
@Slf4j
@RestController
@RequestMapping("/fintech/account")
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "CreateAccount", response = AccountResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = AccountResponse.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = ArgumentsErrorResponseDto.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED"),
            @ApiResponse(code = 403, message = "FORBIDDEN"),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    @PostMapping("/CreateAccount")
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody AccountDto accountdto) {
        Account account1 = accountService.findLastAccountNo();
        long customerId = new AccountSettings().createCustomer(account1.getCustomerID(),
                accountdto.getCustomertype());
        long accountNo = new AccountSettings().createAccount(account1.getAccountNo());
        Account account = new Account();
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

    @ApiOperation(value = "UpdateAccount", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = String.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = ArgumentsErrorResponseDto.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED"),
            @ApiResponse(code = 403, message = "FORBIDDEN"),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    @PutMapping("/UpdateAccount")
    public ResponseEntity<?> update(@Valid @RequestBody AccountDto accountDto){

        Optional<Account> account = accountService.findByAccountNo(accountDto.getAccountNo());
        account.ifPresentOrElse(
                o -> log.info("findByAccountNo {}: {}",accountDto.getAccountNo(), o),
                () -> log.info("findByAccountNo {}: null", accountDto.getAccountNo())
        );
        if(account.isEmpty()){
            return new ResponseEntity<>(new UpdateAccountResponse("Account does not exist"), HttpStatus.BAD_REQUEST);
        }else{
            accountService.updateAccount(accountDto.getAddress(), accountDto.getEmail(),
                    accountDto.getFirstName(), accountDto.getGender(), accountDto.getLastName(),
                    accountDto.getOtherNames(), accountDto.getPhone(), accountDto.getAccountNo());
        }
        return new ResponseEntity<>(new UpdateAccountResponse("Updated successfully"), HttpStatus.OK);
    }

    @ApiOperation(value = "getAccount/accountNo", response = Account.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = Account.class),
            @ApiResponse(code = 400, message = "BAD REQUEST"),
            @ApiResponse(code = 401, message = "UNAUTHORIZED"),
            @ApiResponse(code = 403, message = "FORBIDDEN"),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    @RequestMapping("/getAccount/{accountNo}")
    @ResponseBody
    public ResponseEntity<?> getAccount(@PathVariable long accountNo) {
        Optional<Account> account = accountService.findByAccountNo(accountNo);
        account.ifPresentOrElse(
                o -> log.info("getAccount {}: {}", accountNo, o),
                () -> log.info("getAccount {}: null", accountNo));
        if(account.isEmpty()){
            return new ResponseEntity<>("Account does not exist", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(account, HttpStatus.OK);
        }

    }

    /**
     * Implement a get all account by customerID here
     */


}
