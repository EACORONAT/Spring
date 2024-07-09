package com.eact.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.eact.webapp.springboot_web.models.User;

@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Eduardo", "Corona", "ecooorona@gmail.com");
        model.addAttribute("pestaña", "Spring Boot");
        model.addAttribute("titulo", "Hola Mundo");
        model.addAttribute("usuario", user);        
        
        return "details"; // Vista HTML
    }

    // ArrayList
    @GetMapping("/alist")
    public String alist(ModelMap model){
        List<User> users = new ArrayList<>();

        model.addAttribute("pestaña", "Listas");
        model.addAttribute("titulo", "Lista de usuarios:");
        model.addAttribute("usuarios", users);
        return "list";
    }

    // Array
    @GetMapping("/arreglo")
    public String arrayslist(ModelMap model){
        List<User> users = Arrays.asList(new User("Eduardo", "Corona" ,"ecooorona@gmail.com"),
                                         new User("Alejandro", "Corona", "acooorona@gmail.com"),
                                         new User("Yeudiel", "Marín", "yeum14@gmail.com"),
                                         new User("Iván", "Torres"));

        model.addAttribute("pestaña", "Listas");
        model.addAttribute("titulo", "Lista de usuarios:");
        model.addAttribute("usuarios", users);
        return "list";
    }
}
