package com.example.projectmanagement.controller;

import com.example.projectmanagement.model.Proyecto; // Asegúrate de tener esta clase creada
import com.example.projectmanagement.service.ProyectoService; // Asegúrate de tener este servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public String listarProyectos(Model model) {
        model.addAttribute("proyectos", proyectoService.obtenerTodosLosProyectos());
        return "api/proyectos"; // Asegúrate de que este es el nombre correcto del template
    }

    @PostMapping("/agregar")
    public String agregarProyecto(@RequestParam String nombre, @RequestParam String descripcion) {
        Proyecto nuevoProyecto = new Proyecto();
        nuevoProyecto.setNombre(nombre);
        nuevoProyecto.setDescripcion(descripcion);
        proyectoService.guardarProyecto(nuevoProyecto);
        return "redirect:/api/proyectos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return "redirect:/api/proyectos";
    }

    @PostMapping("/editar/{id}")
    public String editarProyecto(@PathVariable Long id, @RequestParam String nombre, @RequestParam String descripcion) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        if (proyecto != null) {
            proyecto.setNombre(nombre);
            proyecto.setDescripcion(descripcion);
            proyectoService.guardarProyecto(proyecto);
        }
        return "redirect:/api/proyectos";
    }
}
