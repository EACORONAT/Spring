package com.eact.springboot.di.app.springboot_di.models;

public class Product implements Cloneable{
    // Atributos:
    private Long id;
    private String nombre;
    private Long precio;

    // Constructores:
    public Product() {

    }
    public Product(Long id, String nombre, Long precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getter's y Setter's:
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
    public Long getPrecio() {
        return precio;
    }
    public void setPrecio(Long precio) {
        this.precio = precio;
    }
    
    @Override
    public Object clone() {
        try {
            return super.clone();            
        } catch (CloneNotSupportedException e) {
            return new Product(id, nombre, precio);
        }       
    }    
}
