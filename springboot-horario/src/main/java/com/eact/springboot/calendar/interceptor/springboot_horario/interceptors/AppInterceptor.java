package com.eact.springboot.calendar.interceptor.springboot_horario.interceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("interceptor")
public class AppInterceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private Integer open;

    @Value("${config.calendar.close}")
    private Integer close;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);

        System.out.println(hora);

        if (hora >= open && hora < close) {
            StringBuilder mensaje = new StringBuilder("¡Bienvenid@! ");
            mensaje.append("Abierto desde las: ");
            mensaje.append(open);
            mensaje.append(" hrs. ");
            mensaje.append("hasta las: ");
            mensaje.append(close);
            mensaje.append(" hrs. ");
            mensaje.append("¡Gracias por tu preferencia!");
            request.setAttribute("mensaje", mensaje.toString());
            return true;
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> fecha = new HashMap<>();
        StringBuilder mensaje = new StringBuilder("¡Cerrado! (Fuera del horario de consulta).");
        mensaje.append("Por favor visitanos desde las: ");
        mensaje.append(open);
        mensaje.append(" hrs. ");
        mensaje.append("hasta las: ");
        mensaje.append(close);
        mensaje.append(" hrs. ¡Gracias!");
        fecha.put("mensaje", mensaje.toString());
        fecha.put("fecha", new Date().toString());

        response.setContentType("aplication/json");
        response.setStatus(401);
        response.getWriter().write(mapper.writeValueAsString(fecha));

        return false;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        
    }
}
