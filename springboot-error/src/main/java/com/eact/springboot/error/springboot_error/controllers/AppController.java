package com.eact.springboot.error.springboot_error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eact.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.eact.springboot.error.springboot_error.models.domain.User;
import com.eact.springboot.error.springboot_error.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService servicio;

    @GetMapping
    public String index(){
        // Error
        // int value = 100 / 0;
        // int value = Integer.parseInt("10");
        int value = Integer.parseInt("10X");
        System.out.println(value);
        
        return "200 - OK (Sin errores)";
    }

    @GetMapping("/show/{id}")    
    public User show(@PathVariable(name = "id") Long id){        
        User user = servicio.findById(id).orElseThrow(() -> new UserNotFoundException("Error"));        
        System.out.println(user.getId());
        return user;
    }
}
