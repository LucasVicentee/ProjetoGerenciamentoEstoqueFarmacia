package com.LucasVicentee.GerenciamentoDeEstoque.controllers;

import com.LucasVicentee.GerenciamentoDeEstoque.dto.CadastroDTO;
import com.LucasVicentee.GerenciamentoDeEstoque.dto.UsuarioResponseDTO;
import com.LucasVicentee.GerenciamentoDeEstoque.entities.Usuario;
import com.LucasVicentee.GerenciamentoDeEstoque.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CadastroController {

    private UsuarioRepository usuarioRepository;

    public CadastroController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/Cadastro")
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody CadastroDTO dto) {
        // Converter DTO para entidade
        Usuario usuario = new Usuario();
        usuario.setUsuario(dto.getUsuario());
        usuario.setEmail(dto.getEmail());

        //Salvando a senha já criptografada
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(dto.getSenha()));

        Usuario usuarioCadastrado = usuarioRepository.save(usuario);

        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO(
                usuarioCadastrado.getId(),
                usuarioCadastrado.getUsuario(),
                usuarioCadastrado.getEmail()
        );
        return ResponseEntity.ok(responseDTO);
    }
}
