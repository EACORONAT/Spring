package com.eact.springboot.di.factura.springboot_di_factura.models;

public class Product {
    private String nombre;    
    private Integer precio;
    
    public Product() {
    }

    public Product(String nombre, Integer precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }        
}
