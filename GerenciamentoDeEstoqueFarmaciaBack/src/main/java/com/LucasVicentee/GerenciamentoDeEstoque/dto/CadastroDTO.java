package com.LucasVicentee.GerenciamentoDeEstoque.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CadastroDTO {

    @NotBlank
    @Size(min = 3, max = 100)
    private String usuario;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 18)
    private String senha;

    public CadastroDTO() {

    }

    public CadastroDTO(String usuario, String email, String senha) {
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
