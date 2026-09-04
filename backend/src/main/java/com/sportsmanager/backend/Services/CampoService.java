package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Dto.CampoCreateDto;
import com.sportsmanager.backend.Dto.CampoResponseDto;
import com.sportsmanager.backend.Entities.Campo;
import com.sportsmanager.backend.Repositories.CampoRepo;
import com.sportsmanager.backend.Repositories.ReservaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampoService {

    private CampoRepo campoRepo;

    public CampoService(CampoRepo campoRepo) {
        this.campoRepo = campoRepo;
    }

    public CampoResponseDto criarCampo(CampoCreateDto campo){
        Campo campofinal = new Campo(
                campo.getDesporto(),
                campo.getNome(),
                campo.getPrecoPorHora()
        );
        Campo campoGuardado = campoRepo.save(campofinal);
        return converterParaDto(campoRepo.save(campoGuardado));
    }

    public List<CampoResponseDto> obterTodosOsCampos(){
        return campoRepo.findAll().stream().map(this::converterParaDto).toList();
    }

    public Optional<CampoResponseDto> obterCampoPorId(Long id) {
        return campoRepo.findById(id).map(this::converterParaDto);
    }

    private CampoResponseDto converterParaDto (Campo campo){
        return new CampoResponseDto(
          campo.getId(),
          campo.getNome(),
          campo.getTipo(),
          campo.getPrecoPorHora()
        );
    }
}
