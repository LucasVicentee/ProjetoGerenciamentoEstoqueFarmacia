package com.LucasVicentee.GerenciamentoDeEstoque.controllers;

import com.LucasVicentee.GerenciamentoDeEstoque.dto.CadastroDTO;
import com.LucasVicentee.GerenciamentoDeEstoque.dto.UsuarioResponseDTO;
import com.LucasVicentee.GerenciamentoDeEstoque.entities.Usuario;
import com.LucasVicentee.GerenciamentoDeEstoque.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Serve a página HTML
    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    // Recebe dados do frontend via POST
    @PostMapping("/usuarios")
    @ResponseBody
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody CadastroDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(dto.getUsuario());
        usuario.setEmail(dto.getEmail());

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