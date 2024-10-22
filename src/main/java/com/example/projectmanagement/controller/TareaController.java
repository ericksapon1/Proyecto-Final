package com.example.projectmanagement.controller;

import com.example.projectmanagement.model.Tarea; // Asegúrate de tener esta clase creada
import com.example.projectmanagement.service.TareaService; // Asegúrate de tener este servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Método para listar todas las tareas
    @GetMapping
    public String listarTareas(Model model) {
        model.addAttribute("tareas", tareaService.obtenerTodasLasTareas());
        return "api/tareas"; // Asegúrate de que este es el nombre correcto del template
    }

    // Método para mostrar el formulario de agregar tarea
    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("tarea", new Tarea()); // Crear un objeto Tarea vacío
        return "api/tareas/agregar"; // Asegúrate de que esta plantilla existe
    }

    // Método para agregar una nueva tarea
    @PostMapping("/agregar")
    public String agregarTarea(@RequestParam String nombre, @RequestParam String descripcion) {
        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setNombre(nombre);
        nuevaTarea.setDescripcion(descripcion);
        tareaService.guardarTarea(nuevaTarea);
        return "redirect:/api/tareas"; // Asegúrate de que esta ruta exista
    }


    // Método para eliminar una tarea
    @PostMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return "redirect:/api/tareas"; // Redirigir a la lista de tareas después de eliminar
    }

    // Método para editar una tarea
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        model.addAttribute("tarea", tarea); // Pasar la tarea a la vista
        return "api/tareas/editar"; // Asegúrate de que esta plantilla existe
    }

    @PostMapping("/editar/{id}")
    public String editarTarea(@PathVariable Long id, @RequestParam String nombre, @RequestParam String descripcion) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        if (tarea != null) {
            tarea.setNombre(nombre);
            tarea.setDescripcion(descripcion);
            tareaService.guardarTarea(tarea);
        }
        return "redirect:/api/tareas"; // Redirigir a la lista de tareas después de editar
    }
}
