package com.example.s19d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.s19d2.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}