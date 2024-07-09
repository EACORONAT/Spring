package com.eact.webapp.springboot_web.models.dto.User;

public class ParamDTO {
    // Parametros
    private String txt;
    private String mensaje;
    private Integer id;

    // Constructor vacio
    public ParamDTO() {
    
    }
    // Constructor medio
    public ParamDTO(String txt, String mensaje) {
        this.txt = txt;
        this.mensaje = mensaje;                
    }
    // Constructor completo
    public ParamDTO(String txt, String mensaje, Integer id) {
        this.txt = txt;
        this.mensaje = mensaje;        
        this.id = id;        
    }

    // Setter's y Getter's
    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }   
}
