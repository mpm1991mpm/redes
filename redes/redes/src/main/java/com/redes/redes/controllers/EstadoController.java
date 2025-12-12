package com.redes.redes.controllers;

import com.redes.redes.dto.EstadoEntradaDTO;
import com.redes.redes.dto.EstadoSalidaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EstadoController {

    static ArrayList<EstadoSalidaDTO> datos=new ArrayList<>();

    @PostMapping("/registroEstado")
    public ResponseEntity<String> registroEstado(@RequestBody EstadoEntradaDTO datosRegistro) {
        EstadoSalidaDTO salida = new EstadoSalidaDTO(datosRegistro.getNombreRed(), datosRegistro.getEstado());
        datos.add(salida);
        return ResponseEntity.ok().body("Estado registrado");
    }

    @GetMapping("/verEstado")
    public ResponseEntity<ArrayList<EstadoSalidaDTO>> verEstado() {
        return ResponseEntity.ok().body(datos);
    }

}
