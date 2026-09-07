package com.sportsmanager.backend.Mappers;

import com.sportsmanager.backend.Dto.FaturaResponseDto;
import com.sportsmanager.backend.Entities.Fatura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel ="spring")
public interface FaturaMapper {

    @Mapping(source ="dataEmissaoFatura", target ="dataEmissao")
    FaturaResponseDto toDto(Fatura fatura);
}
