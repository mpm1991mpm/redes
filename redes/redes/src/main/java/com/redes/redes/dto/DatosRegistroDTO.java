package com.redes.redes.dto;

import java.sql.Timestamp;

public class DatosRegistroDTO {

    private String nombreRed;
    private Estados estado;
    static Timestamp fechaHora;

    public DatosRegistroDTO(String nombreRed, Estados estado) {
        this.nombreRed = nombreRed;
        this.estado = estado;
    }

    public DatosRegistroDTO() {
    }

    public String getNombreRed() {
        return nombreRed;
    }

    public void setNombreRed(String nombreRed) {
        this.nombreRed = nombreRed;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public static Timestamp getFechaHora() {
        return fechaHora;
    }

    public static void setFechaHora(Timestamp fechaHora) {
        DatosRegistroDTO.fechaHora = fechaHora;
    }
}
