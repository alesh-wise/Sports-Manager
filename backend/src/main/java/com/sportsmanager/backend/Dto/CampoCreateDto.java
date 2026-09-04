package com.sportsmanager.backend.Dto;

import com.sportsmanager.backend.Entities.TipoDesporto;

import java.math.BigDecimal;

public class CampoCreateDto {
    private String nome;
    private TipoDesporto desporto;
    private BigDecimal precoPorHora;

    public CampoCreateDto(String nome, TipoDesporto desporto,  BigDecimal precoPorHora) {
        this.nome = nome;
        this.desporto = desporto;
        this.precoPorHora = precoPorHora;
    }

    public BigDecimal getPrecoPorHora() {
        return precoPorHora;
    }

    public void setPrecoPorHora(BigDecimal precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDesporto getDesporto() {
        return desporto;
    }

    public void setDesporto(TipoDesporto desporto) {
        this.desporto = desporto;
    }
}
