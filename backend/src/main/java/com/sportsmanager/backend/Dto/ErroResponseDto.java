package com.sportsmanager.backend.Dto;

import java.time.LocalDateTime;

public class ErroResponseDto {
    private int  status;
    private String mensagem;
    private LocalDateTime hora;

    public ErroResponseDto(int status, String mensagem, LocalDateTime hora) {
        this.status = status;
        this.mensagem = mensagem;
        this.hora = hora;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
}
