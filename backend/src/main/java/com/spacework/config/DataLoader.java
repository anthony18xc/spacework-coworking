package com.spacework.config;

import com.spacework.model.Espacio;
import com.spacework.repository.EspacioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataLoader {

    // Datos iniciales basados en el prototipo del catalogo de espacios
    @Bean
    CommandLineRunner cargarEspacios(EspacioRepository repo) {
        return args -> {
            if (repo.count() > 0) return;
            repo.save(crear("Escritorio Compartido", "COWORKING", 10, "15.00"));
            repo.save(crear("Oficina Privada", "OFICINA_PRIVADA", 5, "168.75"));
            repo.save(crear("Sala de Reuniones", "SALA_REUNIONES", 20, "25.00"));
        };
    }

    private Espacio crear(String nombre, String tipo, int capacidad, String precioHora) {
        Espacio e = new Espacio();
        e.setNombre(nombre);
        e.setTipo(tipo);
        e.setCapacidad(capacidad);
        e.setPrecioHora(new BigDecimal(precioHora));
        e.setEstado("DISPONIBLE");
        return e;
    }
}
