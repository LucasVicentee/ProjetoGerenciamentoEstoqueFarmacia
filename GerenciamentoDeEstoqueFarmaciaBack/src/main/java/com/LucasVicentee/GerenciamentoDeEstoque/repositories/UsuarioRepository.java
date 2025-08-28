package com.LucasVicentee.GerenciamentoDeEstoque.repositories;

import com.LucasVicentee.GerenciamentoDeEstoque.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class UsuarioRepository {

    public interface usuarioRepository extends JpaRepository<Usuario, Long> {
        Optional<Usuario> findByUsuario(String usuario);
        Optional<Usuario> findByEmail(String email);
    }
}
