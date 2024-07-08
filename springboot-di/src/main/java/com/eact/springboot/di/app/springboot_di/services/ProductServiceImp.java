package com.eact.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eact.springboot.di.app.springboot_di.models.Product;
import com.eact.springboot.di.app.springboot_di.repositories.ProductRepositoryImp;

@Component
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepositoryImp repository;

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double precioImp = p.getPrecio() * 1.25D;
            // Evita redundancia: (inmutabilidad) 1
            //Product prod = new Product(p.getId(), p.getNombre(), precioImp.longValue());
            // Evita redundancia: (inmutabilidad) 2
            Product prod = (Product) p.clone();
            prod.setPrecio(precioImp.longValue());

            return prod;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){        
        return repository.findById(id);
    }
}
