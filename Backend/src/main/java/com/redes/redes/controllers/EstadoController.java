package com.redes.redes.controllers;

import com.redes.redes.dto.EstadoEntradaDTO;
import com.redes.redes.models.HistorialEstado;
import com.redes.redes.repositories.HistorialRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstadoController {

    private final HistorialRepository historialRepository;

    public EstadoController(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    /**
     * Registrar prueba
     * Endpoint: POST /registros-redes
     */
    @PostMapping("/registros-redes")
    public ResponseEntity<String> registroEstado(@RequestBody EstadoEntradaDTO datosRegistro) {

        String textoEstado = datosRegistro.getEstado().getDescripcion();

        HistorialEstado nuevoEstado = new HistorialEstado(
                datosRegistro.getNombreRed(),
                textoEstado
        );

        historialRepository.save(nuevoEstado);
        return ResponseEntity.ok().body("Estado registrado");
    }

    /**
     * Consultar historial
     * Endpoint: GET /registros-redes
     */
    @GetMapping("/registros-redes")
    public ResponseEntity<List<HistorialEstado>> verEstado() {
        return ResponseEntity.ok().body(historialRepository.findAll());
    }
}