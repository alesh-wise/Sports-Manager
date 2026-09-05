package com.sportsmanager.backend.Dto;

import com.sportsmanager.backend.Entities.TipoDesporto;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CampoCreateDto {

    @NotBlank (message ="O campo deve estar identificado")
    private String nome;


    @NotNull
    private TipoDesporto desporto;

    @NotNull
    @DecimalMin(value ="0.01", inclusive = true)
    @Digits(integer =8,  fraction = 2)
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
