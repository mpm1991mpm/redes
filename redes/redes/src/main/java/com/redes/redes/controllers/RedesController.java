package com.redes.redes.controllers;

import com.redes.redes.dto.RedesEntradaDTO;
import com.redes.redes.dto.RedesSalidaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RedesController {

    static ArrayList<RedesSalidaDTO> datosRedes=new ArrayList<>();

    {
        datosRedes.add(new RedesSalidaDTO("Andared_Corporativo", "Nose"));
    }

    @PostMapping("/registroRed")
    public ResponseEntity<String> registroRed(@RequestBody RedesEntradaDTO redes) {
        RedesSalidaDTO salida = new RedesSalidaDTO(redes.getNombre(), redes.getContrasena());
        datosRedes.add(salida);
        return ResponseEntity.ok().body("Red registrada");
    }

    @GetMapping("/verRedes")
    public ResponseEntity<ArrayList<RedesSalidaDTO>> verRedes() {
        return ResponseEntity.ok().body(datosRedes);
    }

}
