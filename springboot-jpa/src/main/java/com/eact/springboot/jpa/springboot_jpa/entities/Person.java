package com.eact.springboot.jpa.springboot_jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="personas")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;    
    private String apellido;
    @Column(name = "lenguaje_prog")
    private String lenguajeProg;

    // Constructor se genera por defecto
    // Nota: Al crear un constructor propio se debe crea por regla uno vacio
    public Person() {
    }    
    public Person(Long id, String nombre, String apellido, String lenguajeProg) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.lenguajeProg = lenguajeProg;
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
    public String getLenguajeprog() {
        return lenguajeProg;
    }
    public void setLenguajeprog(String lenguajeProg) {
        this.lenguajeProg = lenguajeProg;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", lenguajeProg=" + lenguajeProg + "]";
    }          
}
