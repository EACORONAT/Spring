package com.eact.springboot.app.crud.springboot_crud;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.eact.springboot.app.crud.springboot_crud.entities.Product;

@Component
public class ProductValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "es requerido!");

        if(product.getDescription() == null || product.getDescription().isBlank()){
            errors.rejectValue("description", null, "es requerido!");
        }
        if(product.getPrice() == null || product.getPrice() < 500){
            errors.rejectValue("price", null, "es requerido!");
        }
    }

}