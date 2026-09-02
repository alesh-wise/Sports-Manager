package com.sportsmanager.backend.Entities;

import jakarta.persistence.*;

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

    public Campo() {}

    public Campo(Long id, TipoDesporto tipo, String nome) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
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
