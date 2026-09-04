package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Dto.UtilizadorCreateDto;
import com.sportsmanager.backend.Dto.UtilizadorResponseDto;
import com.sportsmanager.backend.Entities.Utilizador;
import com.sportsmanager.backend.Mappers.UtilizadorMapper;
import com.sportsmanager.backend.Repositories.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UtilizadorMapper utilizadorMapper;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder,  UtilizadorMapper utilizadorMapper) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.utilizadorMapper = utilizadorMapper;
    }

    public UtilizadorResponseDto criarUser(UtilizadorCreateDto utilizador){
        Utilizador user = utilizadorMapper.toEntity(utilizador);

        String passwordEncriptada = passwordEncoder.encode(utilizador.getPassword());
        user.setPassword(passwordEncriptada);

        Utilizador userGuardado = userRepo.save(user);

        return utilizadorMapper.toDto(userGuardado);
    }

    public Optional<UtilizadorResponseDto> procurarId(Long id){
        return userRepo.findById(id).map(utilizadorMapper::toDto);
    }

    public List<UtilizadorResponseDto> obterTodosUtilizadores() {
        return userRepo.findAll().stream().map(utilizadorMapper::toDto).toList();
    }


}
