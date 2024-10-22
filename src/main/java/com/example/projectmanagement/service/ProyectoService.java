package com.example.projectmanagement.service;

import com.example.projectmanagement.model.Proyecto;
import com.example.projectmanagement.repository.ProyectoRepository; // Asegúrate de tener el repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    // Método para obtener todos los proyectos
    public List<Proyecto> obtenerTodosLosProyectos() {
        return proyectoRepository.findAll();
    }

    // Método para guardar un proyecto
    public void guardarProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    // Método para eliminar un proyecto por ID
    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    // Método para obtener un proyecto por ID
    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }
}
