package com.eact.springboot.error.springboot_error.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mensaje){
        super(mensaje);
    }
}
