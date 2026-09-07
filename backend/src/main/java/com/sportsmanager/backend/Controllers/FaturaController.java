package com.sportsmanager.backend.Controllers;

import com.sportsmanager.backend.Dto.FaturaResponseDto;
import com.sportsmanager.backend.Entities.Fatura;
import com.sportsmanager.backend.Exceptions.EntidadeNaoEncontrada;
import com.sportsmanager.backend.Mappers.FaturaMapper;
import com.sportsmanager.backend.Repositories.FaturaRepo;
import com.sportsmanager.backend.Services.FaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

    private final FaturaService faturaService;
    private final FaturaRepo faturaRepo;
    private final FaturaMapper faturaMapper;

    public  FaturaController(FaturaService faturaService,  FaturaRepo faturaRepo,  FaturaMapper faturaMapper) {
        this.faturaService = faturaService;
        this.faturaRepo = faturaRepo;
        this.faturaMapper = faturaMapper;
    }

    @PutMapping("/{id}/pagar")
    public ResponseEntity<FaturaResponseDto> pagarFatura(@PathVariable Long id){
        FaturaResponseDto faturaResponseDto = faturaService.pagarFatura(id);
        return ResponseEntity.ok(faturaResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaturaResponseDto> verFatura(@PathVariable Long id) {
        Fatura fatura = faturaRepo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontrada("Fatura não encontrada"));

        return ResponseEntity.ok(faturaMapper.toDto(fatura));
    }

}
