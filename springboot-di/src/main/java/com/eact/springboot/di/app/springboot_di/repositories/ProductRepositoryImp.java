package com.eact.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eact.springboot.di.app.springboot_di.models.Product;

@Component
public class ProductRepositoryImp implements ProductRepository{
    // Atributos:
    private List<Product> data;    

    // Constructor:        
    public ProductRepositoryImp() {
        this.data = Arrays.asList(
            new Product(1L,"Adidas", 1200L),
            new Product(2L,"Charly", 1500L),
            new Product(3L,"Converse", 1000L)            
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
