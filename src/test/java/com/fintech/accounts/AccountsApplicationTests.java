package com.fintech.accounts;

import com.fintech.accounts.model.Account;
import com.fintech.accounts.model.AccountStatus;
import com.fintech.accounts.repository.AccountsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountsApplicationTests {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void create() {

        //create user
        long customerId = new Random().nextLong(100);
        Account account = new Account();
        account.setAccountNo(new Random().nextLong(10000));
        account.setCustomerID(customerId);
        account.setFirstName("Nathan");
        account.setLastName("Nate");
        account.setOtherNames("Test");
        account.setBalance(BigDecimal.ZERO);
        account.setEmail("test@email.com");
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setAddress("testaddress");
        account.setGender("Male");
        account.setPhone("1234567778");
        account.setSmsNotification(false);
        account.setEmailNotification(false);

        //Test creating an account
        entityManager.persist(account);

        //Getting the created account
        Optional<Account> account1 = accountsRepository
                .findByCustomerId(customerId);

        //Verifying created account
        assertNotNull(account1.isEmpty());
        assertEquals("test@email.com", account1.orElseGet(Account::new).getEmail());

    }

}
