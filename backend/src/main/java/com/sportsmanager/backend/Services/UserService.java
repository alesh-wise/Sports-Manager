package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Entities.Utilizador;
import com.sportsmanager.backend.Repositories.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Utilizador criarUser(Utilizador utilizador){
        String passwordEncriptada = passwordEncoder.encode(utilizador.getPassword());
        utilizador.setPassword(passwordEncriptada);
        return userRepo.save(utilizador);
    }

    public Optional<Utilizador> procurarId(Long id){
        return userRepo.findById(id);
    }

    public List<Utilizador> obterTodosUtilizadores() {
        return userRepo.findAll();
    }
}
