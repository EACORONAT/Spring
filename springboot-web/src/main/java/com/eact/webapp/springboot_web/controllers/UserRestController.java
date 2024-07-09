package com.eact.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eact.webapp.springboot_web.models.User;
import com.eact.webapp.springboot_web.models.dto.User.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")

public class UserRestController {    
    // Map
    @GetMapping("/details-map")
    public Map<String, Object> detailsMap(){
        User user = new User("Eduardo", "Corona");
        Map<String, Object> body = new HashMap<>();

        body.put("titulo", "Hola Mundo Spring Boot");
        body.put("usuario", user);        
        
        return body; // Presentación JSON
    }

    // Dto
    @GetMapping("/details-dto")
    public UserDto detailsDto(){

        User user = new User("Eduardo", "Corona");
        UserDto userDto = new UserDto();
        userDto.setUsuario(user);
        userDto.setTitulo("Hola Mundo Spring Boot");
        
        return userDto; // Presentación JSON
    }
    
    // Lista
    @GetMapping("/details-list")
    public List<User> list(){
        User user1 = new User("Eduardo", "Corona");
        User user2 = new User("Alejandro", "Corona");
        User user3 = new User("Yeudiel", "Marín");
        User user4 = new User("Iván", "Torres");

        // Opción 1
        /* List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4); */

        // Opción 2
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        return users;
    }
}
