package com.sportsmanager.backend.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id", nullable=false)
    private Utilizador utilizador;

    @ManyToOne
    @JoinColumn(name ="campo_id", nullable=false)
    private Campo campo;

    @Column(nullable = false)
    private LocalDate dataReserva;


    @Column(nullable = false)
    private LocalTime horaInicio;

    // A hora exata de fim do aluguer
    @Column(nullable = false)
    private LocalTime horaFim;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoTotal;

    public Reserva() {}

    public Reserva(Utilizador utilizador, Campo campo,LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim,  BigDecimal precoTotal) {
        this.utilizador = utilizador;
        this.campo = campo;
        this.dataReserva = dataReserva;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.precoTotal = precoTotal;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilizador getUser() {
        return utilizador;
    }

    public void setUser(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
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
