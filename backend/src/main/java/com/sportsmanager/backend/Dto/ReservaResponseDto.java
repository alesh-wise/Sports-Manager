package com.sportsmanager.backend.Dto;

import com.sportsmanager.backend.Entities.Utilizador;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaResponseDto {

    private Long reservaId;

    private UtilizadorResponseDto utilizador;
    private CampoResponseDto campo;

    private LocalDate dia;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    private String valorTotal;

    public ReservaResponseDto(Long reservaId, UtilizadorResponseDto utilizador, CampoResponseDto campo, LocalDate dia, LocalTime horaFim, LocalTime horaInicio, String valorTotal) {
        this.reservaId = reservaId;
        this.utilizador = utilizador;
        this.campo = campo;
        this.dia = dia;
        this.horaFim = horaFim;
        this.horaInicio = horaInicio;
        this.valorTotal = valorTotal;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public UtilizadorResponseDto getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(UtilizadorResponseDto utilizador) {
        this.utilizador = utilizador;
    }

    public CampoResponseDto getCampo() {
        return campo;
    }

    public void setCampo(CampoResponseDto campo) {
        this.campo = campo;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
}
