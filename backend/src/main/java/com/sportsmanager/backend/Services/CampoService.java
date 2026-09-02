package com.sportsmanager.backend.Services;

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

    public Campo criarCampo(Campo campo){
        return campoRepo.save(campo);
    }

    public List<Campo> obterTodosOsCampos(){
        return campoRepo.findAll();
    }

    public Optional<Campo> obterCampoPorId(Long id) {
        return campoRepo.findById(id);
    }
}
