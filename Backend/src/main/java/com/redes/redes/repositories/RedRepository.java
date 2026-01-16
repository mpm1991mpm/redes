package com.redes.redes.repositories;

import com.redes.redes.models.Red;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RedRepository extends JpaRepository<Red, Long> {
    // Método para buscar por SSID y evitar duplicados
    Optional<Red> findBySsid(String ssid);
}