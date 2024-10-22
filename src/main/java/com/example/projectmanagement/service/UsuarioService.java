package com.example.projectmanagement.service;

import com.example.projectmanagement.model.Usuario;
import com.example.projectmanagement.repository.UsuarioRepository; // Asegúrate de tener el repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Método para guardar un usuario
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    // Método para eliminar un usuario por ID
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para obtener un usuario por ID
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
