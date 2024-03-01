package com.example.s19d2.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MemberException extends RuntimeException {

    private HttpStatus status;

    public MemberException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
