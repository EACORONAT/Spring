package com.eact.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eact.webapp.springboot_web.models.User;
import com.eact.webapp.springboot_web.models.dto.User.ParamDTO;

@RestController
@RequestMapping("/api/var")
public class PVController {

    // Inyeccipon de valores con @Value
    @Value("${config.id}")
    private Integer id;

    @Value("${config.usuario}")
    private String usuario;

    @Value("${config.correo}")
    private String correo;
    
    @Value("${config.clave}")
    private String clave;

    @Value("#{${config.producto}}")
    private Map<String, Object> producto;
    
    @Value("#{${config.ubicacion}}")
    private Map<String, Object> ubicacion;

    @Autowired
    private Environment env;

    // http://localhost:8088/api/var/baz
    // http://localhost:8088/api/var/baz/Prueba
    @GetMapping("/baz/{mensaje}")
    public ParamDTO baz(@PathVariable String mensaje){
    ParamDTO param = new ParamDTO();
    param.setMensaje(mensaje);
    return param;
    }

    // http://localhost:8088/api/var/mix
    // http://localhost:8088/api/var/mix/Adidas/8
    @GetMapping("/mix/{producto}/{id}")
    public Map<String, Object> mix(@PathVariable String producto,
                                   @PathVariable Long id){
    Map<String, Object> json = new HashMap<>();
    json.put("producto", producto);
    json.put("id", id);
    return json;
    }

    // http://localhost:8088/api/var/crear
    // PostMan
    /* 
    {
        "nombre": "Eduardo",
        "apellido": "Vital",
        "correo": "leecord@gmail.com"
    }
    */
    @PostMapping("/crear")
    public User crear(@RequestBody User user){
        // Se crea en la BD
        user.setNombre(user.getNombre().toUpperCase());
        user.setApellido(user.getApellido().toUpperCase());
        user.setCorreo(user.getCorreo().toUpperCase());
        return user;
    }

    // http://localhost:8088/api/var/ivalor
    @GetMapping("/ivalor")
    public Map<String, Object> values() {    
        Map<String, Object> json = new LinkedHashMap<>();
        json.put("id", id);
        json.put("usuario", usuario);
        json.put("correo", correo);
        json.put("clave", clave);
        json.put("clavedos", env.getProperty("config.clave"));
        // Anidar configuración:
        json.put("ubicacion", ubicacion);
        json.put("producto", producto);
    
        return json;
    }
}
