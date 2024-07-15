package com.eact.springboot.app.aop.springboot_aop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eact.springboot.app.aop.springboot_aop.services.GrettingService;

@RestController
public class GreetingController {

    @Autowired
    private GrettingService greeting;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", greeting.sayHi("Eduardo", "Hey")));
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", greeting.sayHiError("Eduardo", "Hey")));
    }
}
