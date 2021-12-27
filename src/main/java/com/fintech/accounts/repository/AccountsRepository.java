package com.fintech.accounts.repository;

import com.fintech.accounts.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 *@author: Nathan
 *
 */

@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {


    @Modifying
    @Query(value = "insert into accounts (firstname, lastname, email) " +
            "values(?,?,?)", nativeQuery = true)
    @Transactional
    void  createAccount(Account account);

    @Query(value = "select * from account where customerid = ?",
            nativeQuery = true)
    @Transactional
    Optional<Account> findByCustomerId(long id);

    @Query(value = "select * from account order by id desc LIMIT 0,1",
            nativeQuery = true)
    @Transactional
    Account findLastAccountNo();


}
