package com.second.ecommerce.Exceptions;

import com.second.ecommerce.Exceptions.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationError(MethodArgumentNotValidException ex){

        String error=ex.getBindingResult().getFieldErrors().stream().findFirst().map(err -> err.getField() + ": " + err.getDefaultMessage()).orElse("Validation Failed");

        ErrorDTO message= new ErrorDTO(error);

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }




}
