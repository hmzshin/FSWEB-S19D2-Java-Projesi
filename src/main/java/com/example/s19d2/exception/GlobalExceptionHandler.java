package com.example.s19d2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @SuppressWarnings("null")
    @ExceptionHandler(MemberException.class)
    public ResponseEntity<ExceptionResponse> handleMemberException(MemberException memberException) {
        ExceptionResponse globalExceptionResponse = new ExceptionResponse(memberException.getStatus(),
                memberException.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(globalExceptionResponse, memberException.getStatus());
    }

    @SuppressWarnings("null")
    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ExceptionResponse> handleAccountException(AccountException accountException) {
        ExceptionResponse globalExceptionResponse = new ExceptionResponse(accountException.getStatus(),
                accountException.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(globalExceptionResponse, accountException.getStatus());
    }

    @SuppressWarnings("null")
    @ExceptionHandler(RoleException.class)
    public ResponseEntity<ExceptionResponse> handleRoleException(RoleException roleException) {
        ExceptionResponse globalExceptionResponse = new ExceptionResponse(roleException.getStatus(),
                roleException.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(globalExceptionResponse, roleException.getStatus());
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        ExceptionResponse errorResponse = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
