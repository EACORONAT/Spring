package com.eact.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Orden de ejecucion:
@Order(2)
@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());    

    // Corte antes del metodo: GrettingService.sayHi 
    @Before("execution(String com.eact.springboot.app.aop.springboot_aop.services.GrettingService.sayHi(..))")
    public void loggerBefore(JoinPoint joinP){
        String metodo = joinP.getSignature().getName();
        String args = Arrays.toString(joinP.getArgs());

        logger.info("Antes del metodo (" + metodo + ") con los argumentos " + args);
    }
    // Corte despues del metodo: GrettingService.sayHi 
    @After("execution(String com.eact.springboot.app.aop.springboot_aop.services.GrettingService.sayHi(..))")
    public void loggerAfter(JoinPoint joinP){
        String metodo = joinP.getSignature().getName();
        String args = Arrays.toString(joinP.getArgs());

        logger.info("Despues del metodo (" + metodo + ") con los argumentos " + args);
    }
    // Corte despues de retornar en la clase: GrettingService.* 
    @AfterReturning("GreetingServicePointCut.greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinP){
        String metodo = joinP.getSignature().getName();
        String args = Arrays.toString(joinP.getArgs());

        logger.info("Despues de retornar en el metodo (" + metodo + ") con los argumentos " + args);
    }
    // Corte despues de lanzar excepcion en el metodo: GrettingService.sayHi 
    @AfterThrowing("GreetingServicePointCut.greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinP){
        String metodo = joinP.getSignature().getName();
        String args = Arrays.toString(joinP.getArgs());

        logger.info("Despues de lanzar excepcion en el metodo (" + metodo + ") con los argumentos " + args);
    }

    // Engloba todo:
    @Around("GreetingServicePointCut.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String metodo = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object resultado = null;
        try {
            logger.info("Antes del metodo (" + metodo + ") con los argumentos " + args);
            resultado = joinPoint.proceed();
            logger.info("Despues del metodo (" + metodo + ") con el resultado: " + resultado);
            return resultado;
        } catch (Throwable e) {
            logger.error("Error en el metodo (" + metodo + ")");
            throw e;
        }        
    }
}
