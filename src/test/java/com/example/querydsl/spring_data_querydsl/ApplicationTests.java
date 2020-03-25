package com.example.querydsl.spring_data_querydsl;

import com.example.querydsl.spring_data_querydsl.entity.Account;
import com.example.querydsl.spring_data_querydsl.entity.AccountRepository;
import com.example.querydsl.spring_data_querydsl.entity.QAccount;
import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Asserts.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
class ApplicationTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void contextLoads() {
        Account account = new Account();
        account.setFirstname("Test File");
        account.setLastname("Spring Data JPA");
        account.setUsername("choi");
        accountRepository.save(account);

        Predicate choi = QAccount.account.username.contains("choi");
        final Optional<Account> one = accountRepository.findOne(choi);

        assertTrue(one.isPresent());

    }

}
