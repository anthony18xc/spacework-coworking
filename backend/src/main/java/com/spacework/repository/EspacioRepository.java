package com.spacework.repository;

import com.spacework.model.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EspacioRepository extends JpaRepository<Espacio, Long> {
    List<Espacio> findByTipo(String tipo);
}
