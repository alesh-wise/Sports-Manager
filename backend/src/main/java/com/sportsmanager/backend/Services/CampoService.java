package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Dto.CampoCreateDto;
import com.sportsmanager.backend.Dto.CampoResponseDto;
import com.sportsmanager.backend.Entities.Campo;
import com.sportsmanager.backend.Mappers.CampoMapper;
import com.sportsmanager.backend.Repositories.CampoRepo;
import com.sportsmanager.backend.Repositories.ReservaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampoService {

    private final CampoRepo campoRepo;
    private final CampoMapper campoMapper;
    public CampoService(CampoRepo campoRepo, CampoMapper campoMapper) {
        this.campoRepo = campoRepo;
        this.campoMapper = campoMapper;
    }

    public CampoResponseDto criarCampo(CampoCreateDto campo){
        Campo campofinal = campoMapper.toEntity(campo);
        Campo campoGuardado = campoRepo.save(campofinal);
        return campoMapper.toDto(campoRepo.save(campoGuardado));
    }

    public List<CampoResponseDto> obterTodosOsCampos(){
        return campoRepo.findAll().stream().map(campoMapper::toDto).toList();
    }

    public Optional<CampoResponseDto> obterCampoPorId(Long id) {
        return campoRepo.findById(id).map(campoMapper::toDto);
    }

}
