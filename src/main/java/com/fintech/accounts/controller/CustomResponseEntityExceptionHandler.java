package com.fintech.accounts.controller;

import com.fintech.accounts.dto.ArgumentsErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;

/**
 * @author: Nathan
 */
@ControllerAdvice
public class CustomResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ArgumentsErrorResponseDto> handle(ConstraintViolationException exception) {
        String errorMessage = new ArrayList<>(exception.getConstraintViolations()).get(0).getMessage();
        ArgumentsErrorResponseDto argumentsErrorResponseDto = new ArgumentsErrorResponseDto(errorMessage, errorMessage, 1000);
        return new ResponseEntity<ArgumentsErrorResponseDto>(argumentsErrorResponseDto, null, HttpStatus.BAD_REQUEST);
    }
}
