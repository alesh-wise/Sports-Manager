package com.sportsmanager.backend.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Campo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "campo")
    private List<Reserva> reservas;

    //Converte o tipo para String
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private TipoDesporto tipo;

    @Column(nullable=false)
    private String nome;

    @Column(nullable=false, precision=10, scale=2)
    private BigDecimal precoPorHora;


    public Campo() {}

    public Campo(TipoDesporto tipo, String nome,  BigDecimal precoPorHora) {
        this.tipo = tipo;
        this.nome = nome;
        this.precoPorHora = precoPorHora;
    }

    public BigDecimal getPrecoPorHora() {
        return precoPorHora;
    }

    public void setPrecoPorHora(BigDecimal precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public TipoDesporto getTipo() {
        return tipo;
    }

    public void setTipo(TipoDesporto tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
