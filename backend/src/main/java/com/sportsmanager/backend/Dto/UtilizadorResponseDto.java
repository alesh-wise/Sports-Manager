package com.sportsmanager.backend.Dto;

import com.sportsmanager.backend.Entities.Utilizador;

public class UtilizadorResponseDto {
    private Long id;
    private String email;
    private String name;

    public UtilizadorResponseDto(Long id, String email, String nome) {
        this.id = id;
        this.email = email;
        this.name = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }
}
