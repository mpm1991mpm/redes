package com.redes.redes.controllers;

import com.redes.redes.dto.RedesEntradaDTO;
import com.redes.redes.dto.RedesSalidaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Controlador para gestionar las redes
 * @Author Miguel y Juan Carlos
 * @version 1.0
 * @since 2025-12-12
 */
@RestController
public class RedesController {

    static ArrayList<RedesSalidaDTO> datosRedes=new ArrayList<>();

    {
        datosRedes.add(new RedesSalidaDTO("Andared_Corporativo", "Nose"));
    }

    /**
     * Registro de una nueva red
     * @param redes redes a registrar
     * @return ResponseEntity<String>
     */
    @PostMapping("/registroRed")
    public ResponseEntity<String> registroRed(@RequestBody RedesEntradaDTO redes) {
        for (RedesSalidaDTO nuevaRed : datosRedes) {
            if (nuevaRed.getNombre().equals(redes.getNombre())) {
                return ResponseEntity.badRequest().body("La red ya existe");
            }
        }
        RedesSalidaDTO salida = new RedesSalidaDTO(redes.getNombre(), redes.getContrasena());
        datosRedes.add(salida);
        return ResponseEntity.ok().body("Red registrada");
    }
    /**
     * Ver las redes registradas
     * @return ResponseEntity<ArrayList<RedesSalidaDTO>>
     */
    @GetMapping("/verRedes")
    public ResponseEntity<ArrayList<RedesSalidaDTO>> verRedes() {
        return ResponseEntity.ok().body(datosRedes);
    }

}
