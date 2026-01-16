package com.redes.redes.repositories;

import com.redes.redes.models.HistorialEstado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialRepository extends JpaRepository<HistorialEstado, Long> {
}