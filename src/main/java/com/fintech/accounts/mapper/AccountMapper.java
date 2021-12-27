//package com.fintech.accounts.mapper;
//
//import com.fintech.accounts.dto.AccountDto;
//import com.fintech.accounts.model.Account;
//import com.fintech.accounts.model.AccountStatus;
//import com.fintech.accounts.validator.AccountValidationException;
//import com.fintech.accounts.validator.AccountValidator;
//import lombok.extern.slf4j.Slf4j;
//import org.mapstruct.InheritInverseConfiguration;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//
//import java.math.BigDecimal;
//import java.util.Random;
//
//@Mapper(componentModel = "spring", imports = {Random.class, BigDecimal.class, Slf4j.class, AccountStatus.class, AccountValidator.class})
//public interface AccountMapper {
//
//    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class );
//
//    //@InheritInverseConfiguration
//    Account dtoToModel(AccountDto accountDto) throws AccountValidationException;
//
//
//    @Mapping(target = "accountNo",  defaultExpression = "java(Random(100000))")
//    @Mapping(target = "customerID",  defaultExpression = "java(Random(10000))")
//    @Mapping(target = "balance", defaultExpression = "java(BigDecimal.ZERO)")
//    //@Mapping(target = "createdDate",  defaultExpression = "java(System.currentTimeMillis())")
//    @Mapping(target = "accountStatus", defaultExpression = "java(AccountStatus.ACTIVE)")
//    AccountDto modelToDto(Account account) throws AccountValidationException;
//}
