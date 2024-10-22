package com.example.projectmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;

    // Otros atributos como estado, fecha de vencimiento, etc. pueden ser añadidos aquí
}
