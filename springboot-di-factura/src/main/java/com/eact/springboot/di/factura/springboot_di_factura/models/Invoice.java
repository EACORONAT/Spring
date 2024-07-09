package com.eact.springboot.di.factura.springboot_di_factura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {    
    @Autowired
    private Client cliente;

    //@Value("${invoice.descripcion}")
    @Value("${invoice.descripcion.off}")
    private String descripcion;

    @Autowired
    private List<Item> lista;       

    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la Factura");
        cliente.setNombre(cliente.getNombre().concat(" Alberto"));
        cliente.setApellido(cliente.getApellido().concat(" Trujillo"));        
    }

    @PreDestroy
    public void distroy(){
        System.out.println("Destruyendo el componente de la Factura");

    }

    public Client getCliente() {
        return cliente;
    }
    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<Item> getLista() {
        return lista;
    }
    public void setLista(List<Item> lista) {
        this.lista = lista;
    }    

    public int getTotal(){
        int total = 0;

        for(Item item : lista){
            total += item.getImporte();
        }

        return total;
    }
}
