package com.redes.redes.dto;

import org.springframework.stereotype.Component;

@Component("LINUX")
public class LinuxDTO {

    private String nombre="Andared_Corporativo";
    private String tipoSeguridad="WPA y WPA2 enterprise";
    private String contrasena;

    public LinuxDTO(String contrasena) {
        this.contrasena = contrasena;
    }

    public LinuxDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoSeguridad() {
        return tipoSeguridad;
    }

    public void setTipoSeguridad(String tipoSeguridad) {
        this.tipoSeguridad = tipoSeguridad;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
