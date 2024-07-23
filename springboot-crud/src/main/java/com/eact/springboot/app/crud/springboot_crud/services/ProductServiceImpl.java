package com.eact.springboot.app.crud.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eact.springboot.app.crud.springboot_crud.entities.Product;
import com.eact.springboot.app.crud.springboot_crud.repositories.ProductRepository;

// Componente de Spring que se encarga de la logica de negocio:
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {        
        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {        
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {        
        return repository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOpt = repository.findById(id);
        if(productOpt.isPresent()){
            Product productDb = productOpt.orElseThrow(); 
            productDb.setName(product.getName());
            productDb.setDescription(product.getDescription());
            productDb.setPrice(product.getPrice());

            return Optional.of(repository.save(productDb));
        }
        return productOpt;       
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productOpt = repository.findById(id);
        productOpt.ifPresent(productDb -> {
            repository.delete(productDb);
        });
        return productOpt;
    }
}
