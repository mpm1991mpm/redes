package com.redes.redes.controllers;

import com.redes.redes.dto.DatosRegistroDTO;
import com.redes.redes.dto.LinuxDTO;
import com.redes.redes.dto.RedesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RedesController {

    static ArrayList<DatosRegistroDTO> datos=new ArrayList<>();
    static ArrayList<RedesDTO> datosRedes=new ArrayList<>();

    {
        datosRedes.add(new RedesDTO("Andared_Corporativo", "Nose", "WPA y WPA2 enterprise"));
    }

    @PostMapping("/registroEstado")
    public ResponseEntity<String> registroEstado(@RequestBody DatosRegistroDTO datosRegistro) {
        datos.add(datosRegistro);
        return ResponseEntity.ok().body("Estado registrado");
    }

    @GetMapping("/verEstado")
    public ResponseEntity<ArrayList<DatosRegistroDTO>> verEstado() {
        return ResponseEntity.ok().body(datos);
    }

    @PostMapping("/registroRed")
    public ResponseEntity<String> registroRed(@RequestBody RedesDTO redes) {
        datosRedes.add(redes);
        return ResponseEntity.ok().body("Red registrada");
    }

    @GetMapping("/verRedes")
    public ResponseEntity<ArrayList<RedesDTO>> verRedes() {
        return ResponseEntity.ok().body(datosRedes);
    }

}
