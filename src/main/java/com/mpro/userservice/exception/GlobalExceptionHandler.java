package com.mpro.userservice.exception;

import com.mpro.userservice.common.ApiResponse;
import com.mpro.userservice.enums.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex){
        ApiResponse<Object> response = new ApiResponse<>(
                ResponseStatus.FAILED,
                ex.getMessage(),
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ApiResponse<Object>> handleBadRequest(BadRequestException ex){
        ApiResponse<Object> response = new ApiResponse<>(
                ResponseStatus.FAILED,
                ex.getMessage(),
                null
        );
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
