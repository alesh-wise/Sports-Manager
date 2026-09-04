package com.sportsmanager.backend.Exceptions;

import com.sportsmanager.backend.Dto.ErroResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandler {

    public ResponseEntity<ErroResponseDto> lidarEntidadeNaoEncontrada(EntidadeNaoEncontrada ex){
        ErroResponseDto erroDto = new ErroResponseDto(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDto);
    }
}
