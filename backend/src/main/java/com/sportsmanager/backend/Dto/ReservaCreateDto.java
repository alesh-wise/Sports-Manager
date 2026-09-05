package com.sportsmanager.backend.Dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaCreateDto {

    @NotNull
    private Long campoID;

    @FutureOrPresent
    private LocalDate dia;

    @NotNull
    private LocalTime horaInicio;

    @NotNull
    private LocalTime horaFim;


    public ReservaCreateDto(){}

    public ReservaCreateDto( Long campoID, LocalDate dia, LocalTime horaFim, LocalTime horaInicio) {
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

