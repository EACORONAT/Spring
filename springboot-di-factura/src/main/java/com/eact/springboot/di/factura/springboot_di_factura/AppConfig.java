package com.eact.springboot.di.factura.springboot_di_factura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.eact.springboot.di.factura.springboot_di_factura.models.Item;
import com.eact.springboot.di.factura.springboot_di_factura.models.Product;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {
    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("Camara Sony", 1500);
        Product p2 = new Product("Camara Canon", 1200);
        List<Item> items = Arrays.asList(new Item(p1, 5), new Item(p2, 3));

        return items;
    }
    
    @Bean
    @Primary
    List<Item> itemsInvoiceOficina(){
        Product p1 = new Product("Monitos Asus 24", 700);
        Product p2 = new Product("Notebook Razer", 2400);
        Product p3 = new Product("Mouse", 300);
        Product p4 = new Product("Impresora HP", 1000);
        List<Item> items = Arrays.asList(new Item(p1, 5), new Item(p2, 3), new Item(p3, 5), new Item(p4, 2));

        return items;
    }
}
