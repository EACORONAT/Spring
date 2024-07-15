package com.eact.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GrettingServiceImpl implements GrettingService{

    @Override
    public String sayHi(String persona, String frace) {
        String greeting = frace + " " + persona + "!";
        System.out.println(greeting);
        return greeting;
    }

    @Override
    public String sayHiError(String persona, String frace) {        
        throw new RuntimeException("Ocurrio un error!");
    }
    
}
