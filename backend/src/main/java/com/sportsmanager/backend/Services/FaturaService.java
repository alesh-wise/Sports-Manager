package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Dto.FaturaResponseDto;
import com.sportsmanager.backend.Entities.EstadoFatura;
import com.sportsmanager.backend.Entities.Fatura;
import com.sportsmanager.backend.Entities.Reserva;
import com.sportsmanager.backend.Exceptions.EntidadeNaoEncontrada;
import com.sportsmanager.backend.Mappers.FaturaMapper;
import com.sportsmanager.backend.Repositories.FaturaRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class FaturaService {


    private final FaturaRepo faturaRepo;
    private final FaturaMapper faturaMapper;
    public FaturaService(FaturaRepo faturaRepo,  FaturaMapper faturaMapper) {
        this.faturaRepo = faturaRepo;
        this.faturaMapper = faturaMapper;
    }


    public Fatura gerarFatura(Reserva reserva) {
        Fatura fatura = new Fatura();

        fatura.setNumeroFatura("FT-" + System.currentTimeMillis());
        fatura.setDataEmissaoFatura(LocalDate.from(LocalDateTime.now()));
        fatura.setEstado(EstadoFatura.PENDENTE);
        String nif = (reserva.getUser().getNif() != null) ? reserva.getUser().getNif() : "999999990";
        fatura.setNifCliente(nif);
        fatura.setValorTotal(reserva.getPrecoTotal());
        fatura.setUtilizador(reserva.getUser());
        fatura.setReserva(reserva);

        return faturaRepo.save(fatura);
    }

    public FaturaResponseDto pagarFatura(Long faturaId){
        Fatura fatura = faturaRepo.findById(faturaId).orElseThrow(()-> new EntidadeNaoEncontrada("Fatura não encontrada"));

        if (fatura.getEstado() == EstadoFatura.PAGA) throw new IllegalArgumentException("Fatura já paga");

        fatura.setEstado(EstadoFatura.PAGA);
        fatura.setDataPagamento(LocalDate.now());
        Fatura faturafinal = faturaRepo.save(fatura);

        return faturaMapper.toDto(faturafinal);
    }


}
