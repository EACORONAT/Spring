package com.eact.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
/* Configuracion de nuevo archivo properties: */
@PropertySources({
    // @PropertySource("classpath:application.properties"),
    // Acepta mas juegos de caracteres: encoding
    @PropertySource(value="classpath:values.properties", encoding = "UTF-8")
})
public class AppConfig {

}
