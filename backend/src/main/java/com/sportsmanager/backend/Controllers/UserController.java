package com.sportsmanager.backend.Controllers;


import com.sportsmanager.backend.Entities.Utilizador;
import com.sportsmanager.backend.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Indica que esta classe responde aos pedidos HTTP e converte o resultado para JSON
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilizador> procurarId(@PathVariable Long id){
        Optional<Utilizador> user = userService.procurarId(id);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Utilizador> obterTodos(){
        return userService.obterTodosUtilizadores();
    }

    @PostMapping
    public Utilizador criarUser(@RequestBody Utilizador utilizador){
        return userService.criarUser(utilizador);
    }

}
