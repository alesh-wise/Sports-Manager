package com.sportsmanager.backend.Controllers;


import com.sportsmanager.backend.Dto.ReservaCreateDto;
import com.sportsmanager.backend.Dto.ReservaResponseDto;
import com.sportsmanager.backend.Entities.Reserva;
import com.sportsmanager.backend.Services.ReservaService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDto> criarReserva(@Valid @RequestBody ReservaCreateDto reserva, Authentication authentication){
        String emailUtilizador = authentication.name();
        ReservaResponseDto reservaDto= reservaService.criarReserva(reserva,emailUtilizador);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaDto);
    }

    @GetMapping("/utilizador/{id}")
    public List<ReservaResponseDto> obterReservaUtilizador(@PathVariable Long id){
        return reservaService.obterReservasUtilizador(id);
    }

    @GetMapping("/campo/{campoId}")
    public List<ReservaResponseDto> porCampoEDia(
            @PathVariable Long campoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dia) {
        return reservaService.obterReservasCampoDia(campoId, dia);
    }
}
