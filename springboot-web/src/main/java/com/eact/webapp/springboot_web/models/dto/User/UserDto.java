package com.eact.webapp.springboot_web.models.dto.User;

import com.eact.webapp.springboot_web.models.User;

public class UserDto {
    // Atributos
    private String titulo;
    private User usuario;
    
    // Getter's y Seter's
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public User getUsuario() {
        return usuario;
    }
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }    
}
