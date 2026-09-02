package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Entities.Reserva;
import com.sportsmanager.backend.Repositories.ReservaRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {

    private ReservaRepo reservaRepo;

    public ReservaService(ReservaRepo reservaRepo) {
        this.reservaRepo = reservaRepo;
    }

    public Reserva criarReserva(Reserva reserva){
        return reservaRepo.save(reserva);
    }

    public List<Reserva> obterReservasUtilizador(Long userId){
        return reservaRepo.findByUserId(userId);
    }

    public List<Reserva> obterReservasCampoDia(Long campoId, LocalDate dia){
        return reservaRepo.findByCampoIdAndDataReserva(campoId, dia);
    }

}

