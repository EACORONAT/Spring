package com.eact.springboot.app.crud.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eact.springboot.app.crud.springboot_crud.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}