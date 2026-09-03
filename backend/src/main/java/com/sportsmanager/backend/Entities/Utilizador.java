package com.sportsmanager.backend.Entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="users")
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "utilizador")
    private List<Reserva> reservas;

    @Column(nullable = false)
    private String password;

    public Utilizador(){}

    public Utilizador(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
