package com.LucasVicentee.GerenciamentoDeEstoque.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank
    private String usuarioOuEmail;

    @NotBlank
    private String senha;

    public LoginDTO() {

    }

    public LoginDTO(String usuarioOuEmail, String senha) {
        this.usuarioOuEmail = usuarioOuEmail;
        this.senha = senha;
    }

    public String getUsuarioOuEmail() {
        return usuarioOuEmail;
    }

    public void setUsuarioOuEmail(String usuarioOuEmail) {
        this.usuarioOuEmail = usuarioOuEmail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
