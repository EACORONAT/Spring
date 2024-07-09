package com.eact.springboot.di.factura.springboot_di_factura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Client {
    @Value("${client.nombre}")
    private String nombre;    
    @Value("${client.apellido}")
    private String apellido;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }     
}
