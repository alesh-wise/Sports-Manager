package com.sportsmanager.backend.Controllers;


import com.sportsmanager.backend.Entities.Campo;
import com.sportsmanager.backend.Services.CampoService;
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
    public List<Campo> obterTodos(){
        return campoService.obterTodosOsCampos();
    }

    @GetMapping("{/id}")
    public ResponseEntity<Campo> obterCampoId(@PathVariable Long id){
        Optional<Campo> campo = campoService.obterCampoPorId(id);

        return campo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Campo CriarCampo(@RequestBody Campo campo){
        return campoService.criarCampo(campo);
    }
}
