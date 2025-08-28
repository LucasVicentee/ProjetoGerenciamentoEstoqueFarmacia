package com.LucasVicentee.GerenciamentoDeEstoque.services;

import com.LucasVicentee.GerenciamentoDeEstoque.dto.CadastroDTO;
import com.LucasVicentee.GerenciamentoDeEstoque.dto.LoginDTO;
import com.LucasVicentee.GerenciamentoDeEstoque.entities.Usuario;
import com.LucasVicentee.GerenciamentoDeEstoque.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(LoginDTO loginDTO) {
        Optional<Usuario> usuarioOptional;

        if (loginDTO.getUsuarioOuEmail().contains("@")) {
            usuarioOptional = usuarioRepository.findByEmail(loginDTO.getUsuarioOuEmail());
        }
        else {
            usuarioOptional = usuarioRepository.findByUsuario(loginDTO.getUsuarioOuEmail());
        }

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (encoder.matches(loginDTO.getSenha(), usuario.getSenha())) {
                return usuario;
            }
        }
        throw new RuntimeException("Login inválido!");
    }

    public Usuario cadastro(CadastroDTO cadastroDTO) {
        Usuario usuario = new Usuario();

        usuario.setUsuario(cadastroDTO.getUsuario());
        usuario.setEmail(cadastroDTO.getEmail());
        usuario.setSenha(cadastroDTO.getSenha());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(cadastroDTO.getSenha()));

        return usuarioRepository.save(usuario);
    }
}
