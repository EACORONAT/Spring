package com.eact.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eact.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.eact.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImp implements UserService{

    private List<User> usuarios;
    public UserServiceImp(){
        this.usuarios = new ArrayList<>();
        usuarios.add(new User(1L, "Eduardo", "Corona", "Usuario"));
        usuarios.add(new User(2L, "Melina", "Gómez", "Usuario"));
        usuarios.add(new User(3L, "Alejandro", "Corona", "Usuario"));
        usuarios.add(new User(4L, "Yeudiel", "Marín", "Usuario"));
        usuarios.add(new User(5L, "Iván", "Torres", "Usuario"));        
    }
    
    @Override
    public List<User> findAll() {        
        return usuarios;
    }

    @Override
    public Optional<User> findById(Long id) {    
        User usuario = null;        
        for (User u : usuarios) {
            if (u.getId().equals(id)) {
                usuario = u;
                break;
            }
        }
        if (usuario == null) {
            throw new UserNotFoundException("Error");
        }        
        return Optional.ofNullable(usuario);
    }
}
