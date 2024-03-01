package com.example.s19d2.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.s19d2.entity.Account;
import com.example.s19d2.exception.AccountException;
import com.example.s19d2.repository.AccountRepository;
import com.example.s19d2.validation.AccountValidation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

   private AccountRepository accountRepository;

   @Override
   public List<Account> findAll() {
      return accountRepository.findAll();
   }

   @SuppressWarnings("null")
   @Override
   public Account save(Account account) {
      AccountValidation.isAccountCredentialsValid(account);
      return accountRepository.save(account);
   }

   @Override
   public Account update(Long id, Account account) {
      AccountValidation.isIdValid(id);
      AccountValidation.isAccountCredentialsValid(account);
      Account existAccount = findById(id);
      account.setId(existAccount.getId());
      return accountRepository.save(account);
   }

   @SuppressWarnings("null")
   @Override
   public Account delete(Long id) {
      AccountValidation.isIdValid(id);
      Account existingAccount = accountRepository.findById(id)
            .orElseThrow(() -> new AccountException("There is no account with given id", HttpStatus.NOT_FOUND));

      accountRepository.delete(existingAccount);
      return existingAccount;

   }

   @SuppressWarnings("null")
   @Override
   public Account findById(Long id) {
      AccountValidation.isIdValid(id);
      Account account = accountRepository.findById(id)
            .orElseThrow(() -> new AccountException("There is no Account with given ID", HttpStatus.NOT_FOUND));
      return account;

   }

}