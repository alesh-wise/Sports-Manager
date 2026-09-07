package com.sportsmanager.backend.Entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String numeroFatura;

    @Column(nullable = true)
    private LocalDate dataPagamento;

    @Column(nullable = false)
    private LocalDate dataEmissaoFatura;

    @Column(nullable = false, length = 9)
    private String nifCliente;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoFatura estado;

    @OneToOne
    @JoinColumn(name ="reserva_id", nullable=false, unique=true)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn (name ="user_id",  nullable=false)
    private Utilizador utilizador;

    public Fatura(Long id, String numeroFatura, LocalDate dataEmissaoFatura, String nifCliente, BigDecimal valorTotal, EstadoFatura estado, Reserva reserva, Utilizador utilizador) {
        this.id = id;
        this.numeroFatura = numeroFatura;
        this.dataEmissaoFatura = dataEmissaoFatura;
        this.nifCliente = nifCliente;
        this.valorTotal = valorTotal;
        this.estado = estado;
        this.reserva = reserva;
        this.utilizador = utilizador;
    }

    public Fatura() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(String numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataEmissaoFatura() {
        return dataEmissaoFatura;
    }

    public void setDataEmissaoFatura(LocalDate dataEmissaoFatura) {
        this.dataEmissaoFatura = dataEmissaoFatura;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public EstadoFatura getEstado() {
        return estado;
    }

    public void setEstado(EstadoFatura estado) {
        this.estado = estado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}
