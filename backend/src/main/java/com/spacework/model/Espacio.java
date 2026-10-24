package com.spacework.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ESPACIO")
public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspacio;

    @Column(nullable = false)
    private String nombre;

    // COWORKING, OFICINA_PRIVADA o SALA_REUNIONES
    @Column(nullable = false)
    private String tipo;

    private int capacidad;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioHora;

    // DISPONIBLE o NO_DISPONIBLE
    @Column(nullable = false)
    private String estado = "DISPONIBLE";

    public Long getIdEspacio() { return idEspacio; }
    public void setIdEspacio(Long idEspacio) { this.idEspacio = idEspacio; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public BigDecimal getPrecioHora() { return precioHora; }
    public void setPrecioHora(BigDecimal precioHora) { this.precioHora = precioHora; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
