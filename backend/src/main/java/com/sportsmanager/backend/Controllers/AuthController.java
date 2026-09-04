package com.sportsmanager.backend.Controllers;


import com.sportsmanager.backend.Dto.LoginDto;
import com.sportsmanager.backend.Dto.LoginResponseDto;
import com.sportsmanager.backend.Services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping ("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto dto) {

    String token = authService.authEGerarToken(dto);

    LoginResponseDto loginResponseDto = new LoginResponseDto(token);

    return ResponseEntity.ok(loginResponseDto);

    }
}
