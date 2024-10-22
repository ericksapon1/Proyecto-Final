package com.example.projectmanagement.repository;

import com.example.projectmanagement.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    // Puedes añadir métodos personalizados si es necesario
}
