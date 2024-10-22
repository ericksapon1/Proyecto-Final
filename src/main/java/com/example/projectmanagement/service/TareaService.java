package com.example.projectmanagement.service;

import com.example.projectmanagement.model.Tarea;
import com.example.projectmanagement.repository.TareaRepository; // Asegúrate de que tienes este repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> obtenerTodasLasTareas() {
        return tareaRepository.findAll(); // Asegúrate de que este método esté en el repositorio
    }

    public Tarea obtenerTareaPorId(Long id) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        return tarea.orElse(null); // Devuelve null si no se encuentra la tarea
    }

    public void guardarTarea(Tarea tarea) {
        tareaRepository.save(tarea); // Guarda la tarea en la base de datos
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id); // Elimina la tarea por id
    }

}
