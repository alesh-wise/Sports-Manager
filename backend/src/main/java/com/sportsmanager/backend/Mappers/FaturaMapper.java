package com.sportsmanager.backend.Mappers;

import com.sportsmanager.backend.Dto.FaturaResponseDto;
import com.sportsmanager.backend.Entities.Fatura;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface FaturaMapper {
    FaturaResponseDto toDto(Fatura fatura);
}
