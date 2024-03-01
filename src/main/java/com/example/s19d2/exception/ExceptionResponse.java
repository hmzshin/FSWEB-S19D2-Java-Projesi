package com.example.s19d2.exception;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ExceptionResponse {
    private HttpStatus status;
    private String message;
    private LocalDateTime createdAt;

}
