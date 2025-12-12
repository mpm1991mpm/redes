package com.redes.redes.controllers;

import com.redes.redes.dto.EstadoEntradaDTO;
import com.redes.redes.dto.EstadoSalidaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Controlador para gestionar los estados de las redes
 * @Author Miguel y Juan Carlos
 * @version 1.0
 * @since 2025-12-12
 */
@RestController
public class EstadoController {

    static ArrayList<EstadoSalidaDTO> datos=new ArrayList<>();

    /**
     * Registro de un nuevo estado
     * @param datosRegistro estado a registrar
     * @return ResponseEntity<String>
     */
    @PostMapping("/registroEstado")
    public ResponseEntity<String> registroEstado(@RequestBody EstadoEntradaDTO datosRegistro) {
        EstadoSalidaDTO salida = new EstadoSalidaDTO(datosRegistro.getNombreRed(), datosRegistro.getEstado());
        datos.add(salida);
        return ResponseEntity.ok().body("Estado registrado");
    }

    /**
     * Ver los estados registrados
     * @return ResponseEntity<ArrayList<EstadoSalidaDTO>>
     */
    @GetMapping("/verEstado")
    public ResponseEntity<ArrayList<EstadoSalidaDTO>> verEstado() {
        return ResponseEntity.ok().body(datos);
    }

}
