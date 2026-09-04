package com.sportsmanager.backend.Controllers;


import com.sportsmanager.backend.Dto.UtilizadorCreateDto;
import com.sportsmanager.backend.Dto.UtilizadorResponseDto;
import com.sportsmanager.backend.Entities.Utilizador;
import com.sportsmanager.backend.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Indica que esta classe responde aos pedidos HTTP e converte o resultado para JSON
@RequestMapping("/utilizadores")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilizadorResponseDto> procurarId(@PathVariable Long id){
        Optional<UtilizadorResponseDto> user = userService.procurarId(id);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<UtilizadorResponseDto> obterTodos(){
        return userService.obterTodosUtilizadores();
    }

    @PostMapping
    public ResponseEntity<UtilizadorResponseDto> criarUser(@RequestBody UtilizadorCreateDto utilizador){
        UtilizadorResponseDto userDto = userService.criarUser(utilizador);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

}
