package com.example.querydsl.spring_data_querydsl.entity;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountRepository extends QuerydslPredicateExecutor<Account>, CustomRepository<Account, Long>{
}
