package com.eact.webapp.springboot_web.models;

public class User {   
    // Atributos
    private String nombre;
    private String apellido;
    private String correo;

    // Constructor vacio
    public User() {
    
    }
    // Constructor medio
    public User(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;                
    }
    // Constructor completo
    public User(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;        
        this.correo = correo;        
    }

    // Getter's y Seter's
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
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
}
