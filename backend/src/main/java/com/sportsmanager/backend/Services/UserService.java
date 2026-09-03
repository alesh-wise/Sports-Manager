package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Dto.UtilizadorCreateDto;
import com.sportsmanager.backend.Dto.UtilizadorResponseDto;
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

    public UtilizadorResponseDto criarUser(UtilizadorCreateDto utilizador){
        Utilizador user = new Utilizador();
        user.setEmail(utilizador.getEmail());
        user.setName(utilizador.getName());

        String passwordEncriptada = passwordEncoder.encode(utilizador.getPassword());
        user.setPassword(passwordEncriptada);

        Utilizador userGuardado = userRepo.save(user);

        return converterParaDto(userGuardado);
    }

    public Optional<UtilizadorResponseDto> procurarId(Long id){
        return userRepo.findById(id).map(this::converterParaDto);
    }

    public List<UtilizadorResponseDto> obterTodosUtilizadores() {
        return userRepo.findAll().stream().map(this::converterParaDto).toList();
    }

    private UtilizadorResponseDto converterParaDto(Utilizador utilizador){
        return new UtilizadorResponseDto(utilizador.getId(),utilizador.getEmail(),utilizador.getPassword());
    }
}
