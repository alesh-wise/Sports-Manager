package com.sportsmanager.backend.Controllers;


import com.sportsmanager.backend.Dto.CampoCreateDto;
import com.sportsmanager.backend.Dto.CampoResponseDto;
import com.sportsmanager.backend.Entities.Campo;
import com.sportsmanager.backend.Services.CampoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campos")
public class CampoController {

    private final CampoService campoService;

    public CampoController(CampoService campoService) {
        this.campoService = campoService;
    }

    @GetMapping
    public List<CampoResponseDto> obterTodos(){
        return campoService.obterTodosOsCampos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampoResponseDto> obterCampoId(@PathVariable Long id){
        Optional<CampoResponseDto> campo = campoService.obterCampoPorId(id);

        return campo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CampoResponseDto> criarCampo(@Valid @RequestBody CampoCreateDto campo){
        CampoResponseDto campoDto= campoService.criarCampo(campo);
        return ResponseEntity.status(HttpStatus.CREATED).body(campoDto);
    }
}
