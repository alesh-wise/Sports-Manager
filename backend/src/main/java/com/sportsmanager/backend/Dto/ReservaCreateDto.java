package com.sportsmanager.backend.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaCreateDto {

    private Long userID;
    private Long campoID;

    private LocalDate dia;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public ReservaCreateDto(Long userID, Long campoID, LocalDate dia, LocalTime horaFim, LocalTime horaInicio) {
        this.userID = userID;
        this.campoID = campoID;
        this.dia = dia;
        this.horaFim = horaFim;
        this.horaInicio = horaInicio;
    }

    public Long getCampoID() {
        return campoID;
    }

    public void setCampoID(Long campoID) {
        this.campoID = campoID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

