package com.eact.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Orden de ejecucion: (1) Primero en entrar y ultimo en salir
@Order(1)
@Component
@Aspect
public class GreetingFooAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());    

    // Corte antes del metodo: GrettingService.sayHi 
    @Before("GreetingServicePointCut.greetingFooLoggerPointCut()")
    public void loggerBefore(JoinPoint joinP){
        String metodo = joinP.getSignature().getName();
        String args = Arrays.toString(joinP.getArgs());

        logger.info("Antes del metodo (" + metodo + ") invocado con los argumentos " + args);
    }
    // Corte despues del metodo: GrettingService.sayHi 
    @After("GreetingServicePointCut.greetingFooLoggerPointCut()")
    public void loggerAfter(JoinPoint joinP){
        String metodo = joinP.getSignature().getName();
        String args = Arrays.toString(joinP.getArgs());

        logger.info("Despues del metodo (" + metodo + ") invocado con los argumentos " + args);
    }
}
