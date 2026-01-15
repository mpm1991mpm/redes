package com.redes.redes.dto;

public class RedesEntradaDTO {

    private String nombre;
    private String contrasena;
    private String seguridad;

    public RedesEntradaDTO(String nombre, String contrasena, String seguridad) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.seguridad = seguridad;
    }

    public RedesEntradaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }
}
