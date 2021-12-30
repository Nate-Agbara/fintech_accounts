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

    @Query(value = "select * from account where account_no = ?",
            nativeQuery = true)
    @Transactional
    Optional<Account> findByAccountNo(long id);

    @Query(value = "select * from account order by id desc LIMIT 0,1",
            nativeQuery = true)
    @Transactional
    Account findLastAccountNo();

    @Modifying
    @Query(value = "update account set address = ?, email = ?, first_name = ?," +
            "gender = ?, last_name = ?, other_names = ?, phone = ? " +
            "where account_no = ?",
    nativeQuery = true)
    @Transactional
    void updateAccount(String address, String email, String firstname, String gentder,
                       String lastname, String othernames, String phone, long accout_no);


}
