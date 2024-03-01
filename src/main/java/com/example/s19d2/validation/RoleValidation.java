package com.example.s19d2.validation;

import org.springframework.http.HttpStatus;

import com.example.s19d2.entity.Role;
import com.example.s19d2.exception.RoleException;

public class RoleValidation {

    private static final String ID_IS_NOT_VALID = "Role id is not valid";
    private static final String ROLE_CREDENTIALS_ARE_NOT_VALID = "Role credentials are not valid";

    public static void isIdValid(Long id) {

        if (id <= 0 || id == null) {
            throw new RoleException(ID_IS_NOT_VALID + id, HttpStatus.BAD_REQUEST);
        }

    }

    public static void isRoleCredentialsValid(Role role) {
        if (role == null || !role.getAuthority().equals("ADMIN") || !role.getAuthority().equals("USER")) {
            throw new RoleException(ROLE_CREDENTIALS_ARE_NOT_VALID, HttpStatus.BAD_REQUEST);
        }
    }

}
