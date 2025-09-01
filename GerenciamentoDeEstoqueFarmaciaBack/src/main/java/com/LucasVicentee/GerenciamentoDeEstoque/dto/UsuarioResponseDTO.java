package com.LucasVicentee.GerenciamentoDeEstoque.dto;

public class UsuarioResponseDTO {

    private Long id;
    private String usuario;
    private String email;

    public UsuarioResponseDTO() {

    }

    public UsuarioResponseDTO(Long id, String usuario, String email) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
