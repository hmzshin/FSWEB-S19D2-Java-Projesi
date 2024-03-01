package com.example.s19d2.validation;

import org.springframework.http.HttpStatus;

import com.example.s19d2.entity.Member;
import com.example.s19d2.exception.MemberException;

public class MemberValidation {

    private static final String ID_IS_NOT_VALID = "Member id is not valid";
    private static final String MEMBER_CREDENTIALS_ARE_NOT_VALID = "Member credentials are not valid";

    public static void isIdValid(Long id) {

        if (id <= 0 || id == null) {
            throw new MemberException(ID_IS_NOT_VALID + id, HttpStatus.BAD_REQUEST);
        }

    }

    public static void isMemberCredentialsValid(Member member) {
        if (member == null || member.getRoles() == null ||
                member.getEmail().isEmpty() || member.getEmail() == null || member.getPassword().isEmpty()
                || member.getPassword() == null) {
            throw new MemberException(MEMBER_CREDENTIALS_ARE_NOT_VALID, HttpStatus.BAD_REQUEST);
        }
    }

}
