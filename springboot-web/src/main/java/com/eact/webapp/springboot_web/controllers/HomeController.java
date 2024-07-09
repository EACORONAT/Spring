package com.eact.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // http://localhost:8088/
    @GetMapping({"", "/", "/inicio"})
    public String inicio(){
        // Carga y redirige a la ruta
        //return "redirect:/arreglo";
        // Carga y mantiene la ruta actual
        return "forward:/details";
    }
}
