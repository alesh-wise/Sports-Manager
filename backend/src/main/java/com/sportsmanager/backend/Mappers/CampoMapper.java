package com.sportsmanager.backend.Mappers;


import com.sportsmanager.backend.Dto.CampoCreateDto;
import com.sportsmanager.backend.Dto.CampoResponseDto;
import com.sportsmanager.backend.Entities.Campo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CampoMapper {

    CampoResponseDto toDto(Campo campo);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    Campo toEntity(CampoCreateDto campoCreateDto);
}
