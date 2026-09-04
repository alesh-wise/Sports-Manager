package com.sportsmanager.backend.Services;

import com.sportsmanager.backend.Dto.LoginDto;
import com.sportsmanager.backend.Entities.Utilizador;
import com.sportsmanager.backend.Exceptions.EntidadeNaoEncontrada;
import com.sportsmanager.backend.Repositories.UserRepo;
import io.jsonwebtoken.Jwt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtService jwt;
    private final UserRepo userRepo;
    private final PasswordEncoder encoder;

    public AuthService(JwtService jwt, UserRepo userRepo, PasswordEncoder encoder) {
        this.jwt = jwt;
        this.userRepo = userRepo;
        this.encoder = encoder;
    }


    public String authEGerarToken(LoginDto dto) {
        Utilizador user = userRepo.findByEmail(dto.getEmail()).orElseThrow(()-> new EntidadeNaoEncontrada("Email ou palavra-passe incorretos"));

        if(!encoder.matches( dto.getPassword(),user.getPassword())){
            throw new EntidadeNaoEncontrada("Email ou palavra-passe incorretos");
        }

        return jwt.gerarToken(dto.getEmail());
    }
}
