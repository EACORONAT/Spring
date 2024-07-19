package com.eact.springboot.jpa.rs.springboot_jpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eact.springboot.jpa.rs.springboot_jpa_relationship.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{
    
}