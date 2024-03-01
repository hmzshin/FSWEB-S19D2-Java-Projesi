package com.example.s19d2.validation;

import org.springframework.http.HttpStatus;

import com.example.s19d2.entity.Account;
import com.example.s19d2.exception.AccountException;

public class AccountValidation {
    private static final String ID_IS_NOT_VALID = "Account id is not valid";
    private static final String ACCOUNT_CREDENTIALS_ARE_NOT_VALID = "Account credentials are not valid";

    public static void isIdValid(Long id) {

        if (id < 0 || id == null) {
            throw new AccountException(ID_IS_NOT_VALID + id, HttpStatus.BAD_REQUEST);
        }

    }

    public static void isAccountCredentialsValid(Account account) {
        if (account == null ||
                account.getName().isEmpty() || account.getName() == null) {
            throw new AccountException(ACCOUNT_CREDENTIALS_ARE_NOT_VALID, HttpStatus.BAD_REQUEST);
        }
    }

}
