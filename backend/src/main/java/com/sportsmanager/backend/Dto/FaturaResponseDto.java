package com.sportsmanager.backend.Dto;

import com.sportsmanager.backend.Entities.EstadoFatura;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FaturaResponseDto {
    private Long id;
    private String numeroFatura;
    private LocalDateTime dataEmissao;
    private LocalDateTime dataPagamento;
    private String nifCliente;
    private BigDecimal valorTotal;
    private EstadoFatura estado;

    public FaturaResponseDto() {}

    public FaturaResponseDto(Long id, String numeroFatura, LocalDateTime dataEmissao, LocalDateTime dataPagamento, String nifCliente, BigDecimal valorTotal, EstadoFatura estado) {
        this.id = id;
        this.numeroFatura = numeroFatura;
        this.dataEmissao = dataEmissao;
        this.dataPagamento = dataPagamento;
        this.nifCliente = nifCliente;
        this.valorTotal = valorTotal;
        this.estado = estado;
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

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
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
}