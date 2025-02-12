package com.example.schedulejpa.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdviceHandler {

    @ExceptionHandler(exception = CustomException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomException(CustomException e){
        log.error("code : {} / message : {}", e.getMessage(), e.getExceptionStatus());
        return new ResponseEntity(new ErrorResponseDto(e.getExceptionStatus().getMessage(), e.getExceptionStatus().getErrorCode()), HttpStatus.valueOf(e.getExceptionStatus().getErrorCode()));
    }

}
