package com.eact.springboot.error.springboot_error.models.domain;

public class User {
    private Long id;
    private String nombre;
    private String apellido;
    private String rol;
    
    public User() {
    }    
    public User(Long id, String nombre, String apellido, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    public String getRol() {
        return rol;
    }    
    public void setRol(String rol) {
        this.rol = rol;
    }        
}
