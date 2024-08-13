package com.loja.loja.excpetion;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ControllerAdvice
public class GlobalHadlerExeption extends ResponseEntityExceptionHandler {

    
    
    @Value("${spring.profiles.active}")
    private String activeProfile;

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<ErrorDetails> handleBusinessException(BusinessException ex, WebRequest request) {
        ErrorDetails errorDetails;

        if ("development".equals(activeProfile)) {
            errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        } else {
            errorDetails = new ErrorDetails(new Date(), "Erro de negócio", null);
        }

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions( Exception ex, WebRequest request) {
        ErrorDetails errorDetails;
        
        if ("development".equals(activeProfile)) {
            errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        } else {
            errorDetails = new ErrorDetails(new Date(), "Erro interno no servidor", null);
        }

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ErrorDetails {
        private Date timestamp;
        private String message;
        private String details;
    }
    
}
