package com.eact.springboot.jpa.rs.springboot_jpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eact.springboot.jpa.rs.springboot_jpa_relationship.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{
    
}