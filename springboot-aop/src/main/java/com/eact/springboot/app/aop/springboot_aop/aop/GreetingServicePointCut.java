package com.eact.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCut {
    // Para mandar a llamar en GrettingAspect
    @Pointcut("execution(String com.eact.springboot.app.aop.springboot_aop.services.GrettingService.*(..))")
    // Metodo publico
    public void greetingLoggerPointCut(){}

    // Para mandar a llamar en GrettingFooAspect
    @Pointcut("execution(String com.eact.springboot.app.aop.springboot_aop.services.GrettingService.*(..))")
    // Metodo publico
    public void greetingFooLoggerPointCut(){}
}
