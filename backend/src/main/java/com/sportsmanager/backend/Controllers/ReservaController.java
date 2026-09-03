package com.sportsmanager.backend.Controllers;


import com.sportsmanager.backend.Entities.Reserva;
import com.sportsmanager.backend.Services.ReservaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }

    @PostMapping
    public Reserva criarReserva(@RequestBody Reserva reserva){
        return reservaService.criarReserva(reserva);
    }

    @GetMapping("/utilizador/{id}")
    public List<Reserva> obterReservaUtilizador(@PathVariable Long id){
        return reservaService.obterReservasUtilizador(id);
    }

    @GetMapping("/campo/{campoId}")
    public List<Reserva> porCampoEDia(
            @PathVariable Long campoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dia) {
        return reservaService.obterReservasCampoDia(campoId, dia);
    }
}
