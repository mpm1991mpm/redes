package com.redes.redes.controllers;

import com.redes.redes.dto.DatosRegistroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RedesController {

    static ArrayList<DatosRegistroDTO> datos=new ArrayList<>();

    @PostMapping("/registroEstado")
    public ResponseEntity<?> registroEstado(@RequestBody DatosRegistroDTO datosRegistro) {
        datos.add(datosRegistro);
        return ResponseEntity.ok().body("Estado registrado");
    }

    @GetMapping("/verEstado")
    public String estado() {
        return "Estado: " + datos.size();
    }
}
