package com.eact.springboot.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor tiemInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Ejecutar todas las rutas:
        registry.addInterceptor(tiemInterceptor);
        // Ejecutar todas las rutas de una ruta base:
        // registry.addInterceptor(tiemInterceptor).addPathPatterns("/app/**");
        // Ejecutar ruta especifica:
        // registry.addInterceptor(tiemInterceptor).addPathPatterns("/app/bar");
        // Excluir ruta especifica:
        // registry.addInterceptor(tiemInterceptor).excludePathPatterns("/app/bar", "/app/foo");
    }    
}
