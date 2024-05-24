package com.example.task2.exception;

import com.example.task2.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler({CommonException.class})
    public Map<String, String> handleException(CommonException exc) {
        Map<String, String> error = new HashMap<>();
        error.put(Constants.MESSAGE, exc.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleException(MethodArgumentNotValidException ex) {
        Map<String, String> error = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(exc -> {
                    error.put(exc.getField(), exc.getDefaultMessage());
                }
        );
        return error;
    }
    @ExceptionHandler({NumberFormatException.class})
    public Map<String, String> handleException(NumberFormatException exc) {
        Map<String, String> error = new HashMap<>();
        error.put(Constants.MESSAGE, Constants.ID_INCORRECT);
        return error;
    }
}
