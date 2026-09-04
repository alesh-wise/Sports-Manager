package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Dto.CampoResponseDto;
import com.sportsmanager.backend.Dto.ReservaCreateDto;
import com.sportsmanager.backend.Dto.ReservaResponseDto;
import com.sportsmanager.backend.Dto.UtilizadorResponseDto;
import com.sportsmanager.backend.Entities.Campo;
import com.sportsmanager.backend.Entities.Reserva;
import com.sportsmanager.backend.Entities.Utilizador;
import com.sportsmanager.backend.Exceptions.EntidadeNaoEncontrada;
import com.sportsmanager.backend.Mappers.ReservaMapper;
import com.sportsmanager.backend.Repositories.CampoRepo;
import com.sportsmanager.backend.Repositories.ReservaRepo;
import com.sportsmanager.backend.Repositories.UserRepo;
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
    private final ReservaMapper reservaMapper;

    public ReservaService(ReservaRepo reservaRepo, UserRepo userRepo, CampoRepo campoRepo, ReservaMapper reservaMapper) {
        this.reservaRepo = reservaRepo;
        this.userRepo = userRepo;
        this.campoRepo = campoRepo;
        this.reservaMapper = reservaMapper;
    }

    public ReservaResponseDto criarReserva(ReservaCreateDto reserva){
        Utilizador user = userRepo.findById(reserva.getUserID()).orElseThrow(()->new EntidadeNaoEncontrada("User não encontrado com o ID"+reserva.getUserID()));

        Campo campo = campoRepo.findById(reserva.getCampoID()).orElseThrow(()-> new EntidadeNaoEncontrada("Campo não encontrado com o ID"+reserva.getCampoID()));

        long minutos = ChronoUnit.MINUTES.between(reserva.getHoraInicio(), reserva.getHoraFim());

        BigDecimal duracaoHoras = BigDecimal.valueOf(minutos).divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP);

        BigDecimal total = campo.getPrecoPorHora().multiply(duracaoHoras);

        Reserva reservafinal = new  Reserva(
                user,campo, reserva.getDia(),reserva.getHoraInicio(),reserva.getHoraFim(),total
        );
        Reserva reservaGuardada = reservaRepo.save(reservafinal);
        return reservaMapper.toDto(reservaGuardada);
    }

    public List<ReservaResponseDto> obterReservasUtilizador(Long userId){
        return reservaRepo.findByUserId(userId).stream().map(reservaMapper::toDto).toList();
    }

    public List<ReservaResponseDto> obterReservasCampoDia(Long campoId, LocalDate dia){
        return reservaRepo.findByCampoIdAndDataReserva(campoId, dia).stream().map(reservaMapper::toDto).toList();
    }


}

