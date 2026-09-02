package com.sportsmanager.backend.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id", nullable=false)
    private User user;

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

    public Reserva() {}

    public Reserva(User user, Campo campo, LocalTime horaInicio, LocalTime horaFim) {
        this.user = user;
        this.campo = campo;
        this.dataReserva = LocalDate.now();
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
