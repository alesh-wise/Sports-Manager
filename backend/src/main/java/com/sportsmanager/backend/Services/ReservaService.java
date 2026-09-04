package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Dto.CampoResponseDto;
import com.sportsmanager.backend.Dto.ReservaCreateDto;
import com.sportsmanager.backend.Dto.ReservaResponseDto;
import com.sportsmanager.backend.Dto.UtilizadorResponseDto;
import com.sportsmanager.backend.Entities.Campo;
import com.sportsmanager.backend.Entities.Reserva;
import com.sportsmanager.backend.Entities.Utilizador;
import com.sportsmanager.backend.Repositories.CampoRepo;
import com.sportsmanager.backend.Repositories.ReservaRepo;
import com.sportsmanager.backend.Repositories.UserRepo;
import org.hibernate.CacheMode;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

@Service
public class ReservaService {

    private ReservaRepo reservaRepo;
    private UserRepo userRepo;
    private CampoRepo campoRepo;

    public ReservaService(ReservaRepo reservaRepo, UserRepo userRepo, CampoRepo campoRepo) {
        this.reservaRepo = reservaRepo;
        this.userRepo = userRepo;
        this.campoRepo = campoRepo;
    }

    public ReservaResponseDto criarReserva(ReservaCreateDto reserva){
        Utilizador user = userRepo.findById(reserva.getUserID()).orElseThrow(()->new RuntimeException("User não encontrado"));

        Campo campo = campoRepo.findById(reserva.getCampoID()).orElseThrow(()-> new RuntimeException("Campo não encontrado"));

        long minutos = ChronoUnit.MINUTES.between(reserva.getHoraInicio(), reserva.getHoraFim());

        BigDecimal duracaoHoras = BigDecimal.valueOf(minutos).divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP);

        BigDecimal total = campo.getPrecoPorHora().multiply(duracaoHoras);

        Reserva reservafinal = new  Reserva(
                user,campo, reserva.getDia(),reserva.getHoraInicio(),reserva.getHoraFim(),total
        );
        Reserva reservaGuardada = reservaRepo.save(reservafinal);
        return converterParaDto(reservaGuardada);
    }

    public List<Reserva> obterReservasUtilizador(Long userId){
        return reservaRepo.findByUserId(userId);
    }

    public List<Reserva> obterReservasCampoDia(Long campoId, LocalDate dia){
        return reservaRepo.findByCampoIdAndDataReserva(campoId, dia);
    }


    private ReservaResponseDto converterParaDto(Reserva reserva){

        UtilizadorResponseDto utilizadorResponseDto = new UtilizadorResponseDto(
                reserva.getUser().getId(),
                reserva.getUser().getEmail(),
                reserva.getUser().getEmail()
        );

        CampoResponseDto campoResponseDto = new CampoResponseDto(
                reserva.getCampo().getId(),
                reserva.getCampo().getNome(),
                reserva.getCampo().getTipo(),
                reserva.getCampo().getPrecoPorHora()
        );

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "PT"));

        String valorFormatado = formatoMoeda.format(reserva.getPrecoTotal());

        return new ReservaResponseDto(
                reserva.getId(),
                utilizadorResponseDto,
                campoResponseDto,
                reserva.getDataReserva(),
                reserva.getHoraInicio(),
                reserva.getHoraFim(),
                valorFormatado
        );
    }
}

