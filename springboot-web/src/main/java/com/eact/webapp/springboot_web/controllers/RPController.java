package com.eact.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eact.webapp.springboot_web.models.dto.User.ParamDTO;
import com.eact.webapp.springboot_web.models.dto.User.ParamMixDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/rp")
public class RPController {
    // http://localhost:8088/api/rp/foo
    // http://localhost:8088/api/rp/foo?mensaje=Hola
    @GetMapping("/foo")
    public ParamDTO foo(@RequestParam(required = false, defaultValue = "¡Hola!") String mensaje){
        ParamDTO param = new ParamDTO();
        param.setMensaje(mensaje);

        return param;
    }

    // http://localhost:8088/api/rp/bar
    // http://localhost:8088/api/rp/bar?txt=Hola%20que%20tal&id=1000
    @GetMapping("/bar")
    public ParamMixDTO bar(@RequestParam(required = false, defaultValue = "¡Hey!") String txt,
                        @RequestParam(required = false, defaultValue = "8") Integer id){
        ParamMixDTO params = new ParamMixDTO();
        params.setTxt(txt);
        params.setId(id);

        return params;
    }

    // http://localhost:8088/api/rp/request
    // http://localhost:8088/api/rp/request?txt=Holaaaa&id=88
    @GetMapping("/request")
    public ParamMixDTO request(HttpServletRequest request){
        ParamMixDTO params = new ParamMixDTO();
        params.setTxt(request.getParameter("txt"));        
        params.setId(Integer.parseInt(request.getParameter("id")));        

        return params;
    }
}
