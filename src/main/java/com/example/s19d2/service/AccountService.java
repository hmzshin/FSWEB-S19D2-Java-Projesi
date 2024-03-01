package com.example.s19d2.service;

import java.util.List;

import com.example.s19d2.entity.Account;

public interface AccountService {

     List<Account> findAll();

     Account findById(Long id);

     Account save(Account account);

     Account update(Long id, Account account);

     Account delete(Long id);

}
