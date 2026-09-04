package com.sportsmanager.backend.Mappers;

import com.sportsmanager.backend.Dto.UtilizadorCreateDto;
import com.sportsmanager.backend.Dto.UtilizadorResponseDto;
import com.sportsmanager.backend.Entities.Utilizador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UtilizadorMapper {
    UtilizadorResponseDto toDto(Utilizador utilizador);

    @Mapping(target ="password", ignore =true)
    @Mapping(target = "id", ignore = true)
    Utilizador toEntity(UtilizadorCreateDto utilizadorCreateDto);
}
