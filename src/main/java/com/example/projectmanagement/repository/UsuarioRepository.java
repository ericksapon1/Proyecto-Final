package com.example.projectmanagement.repository;

import com.example.projectmanagement.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // No es necesario agregar métodos, ya que JpaRepository proporciona los básicos
}
