package com.eact.springboot.app.interceptor.springboot_interceptor.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class FooController {
    @GetMapping("/bac")
    public Map<String,Object> foo(){

        return Collections.singletonMap("mensaje", "Handler bac Controlador");
    }

    @GetMapping("/bar")
    public Map<String,Object> bar(){

        return Collections.singletonMap("mensaje", "Handler bar Controlador");
    }

    @GetMapping("/baz")
    public Map<String,Object> baz(){

        return Collections.singletonMap("mensaje", "Handler baz Controlador");
    }
}
