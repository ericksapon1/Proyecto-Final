package com.example.projectmanagement.controller;

import com.example.projectmanagement.model.Usuario;
import com.example.projectmanagement.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "api/usuarios"; // Verifica que este archivo exista y sea accesible
    }

    @PostMapping("/agregar")
    public String agregarUsuario(@RequestParam String nombre, @RequestParam String email) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setEmail(email);
        usuarioService.guardarUsuario(nuevoUsuario);
        return "redirect:/api/usuarios"; // Redirige a la lista de usuarios después de agregar
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/api/usuarios"; // Redirige a la lista de usuarios después de eliminar
    }

    @PostMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, @RequestParam String nombre, @RequestParam String email) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuarioService.guardarUsuario(usuario);
        }
        return "redirect:/api/usuarios"; // Redirige a la lista de usuarios después de editar
    }
}
