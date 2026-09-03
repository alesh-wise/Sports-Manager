package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Entities.Utilizador;
import com.sportsmanager.backend.Repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Utilizador criarUser(Utilizador utilizador){
        return userRepo.save(utilizador);
    }

    public Optional<Utilizador> procurarId(Long id){
        return userRepo.findById(id);
    }

    public List<Utilizador> obterTodosUtilizadores() {
        return userRepo.findAll();
    }
}
