package com.eact.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.eact.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.eact.springboot.error.springboot_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByCero(Exception ex){

        Error error = new Error();
        error.setFecha(new Date());
        error.setError("Error - División por cero");
        error.setMensaje(ex.getMessage());
        error.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.value());        

        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException ex){

        Error error = new Error();
        error.setFecha(new Date());
        error.setError("Error - 404");
        error.setMensaje(ex.getMessage());
        error.setEstado(HttpStatus.NOT_FOUND.value());        

        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Error> numberFormatEx(NumberFormatException ex){

        Error error = new Error();
        error.setFecha(new Date());
        error.setError("Error - 500 (Formato de número)");
        error.setMensaje(ex.getMessage());
        error.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.value());        

        return ResponseEntity.status(500).body(error);
    }    

    @ExceptionHandler({
        NullPointerException.class, 
        HttpMessageNotWritableException.class,
        UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFound(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("fecha", new Date());
        error.put("error", "El usuario no existe");
        error.put("mensaje", ex.getMessage());        
        error.put("estado", HttpStatus.INTERNAL_SERVER_ERROR.value());        

        return error;
    }
}
