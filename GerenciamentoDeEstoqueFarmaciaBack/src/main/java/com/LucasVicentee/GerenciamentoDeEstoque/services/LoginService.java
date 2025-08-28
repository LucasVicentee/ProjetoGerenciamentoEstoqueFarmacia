package com.LucasVicentee.GerenciamentoDeEstoque.services;

import com.LucasVicentee.GerenciamentoDeEstoque.dto.LoginDTO;
import com.LucasVicentee.GerenciamentoDeEstoque.entities.Usuario;
import com.LucasVicentee.GerenciamentoDeEstoque.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(LoginDTO dto) {
        Optional<Usuario> usuarioOptional;

        if (dto.getUsuarioOuEmail().contains("@")) {
            usuarioOptional = usuarioRepository.findByEmail(dto.getUsuarioOuEmail());
        }
        else {
            usuarioOptional = usuarioRepository.findByUsuario(dto.getUsuarioOuEmail());
        }

        if (usuarioOptional.isPresent() && usuarioOptional.get().getSenha().equals(dto.getSenha())) {
            return usuarioOptional.get();
        }
        else {
            throw new RuntimeException("Login inválido!");
        }
    }
}
