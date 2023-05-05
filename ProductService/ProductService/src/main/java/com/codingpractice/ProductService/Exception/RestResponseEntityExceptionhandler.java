package com.codingpractice.ProductService.Exception;

import com.codingpractice.ProductService.Model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionhandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomException exception){
            return new ResponseEntity<>(new ErrorResponse().builder()
                    .errorMessage(exception.getMessage())
                    .errorCode(exception.getErrorcode())
                    .build(), HttpStatus.NOT_FOUND);
    }
}
