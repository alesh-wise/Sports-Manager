package com.sportsmanager.backend.Mappers;


import com.sportsmanager.backend.Dto.ReservaCreateDto;
import com.sportsmanager.backend.Dto.ReservaResponseDto;
import com.sportsmanager.backend.Entities.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Mapper(componentModel = "spring", uses = {UtilizadorMapper.class, CampoMapper.class})
public interface ReservaMapper {

    @Mapping(source ="precoTotal", target ="valorTotal")
    ReservaResponseDto toDto(Reserva reserva);


    default String formatarPrecoParaString(BigDecimal preco) {
        if (preco == null) {
            return null;
        }
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "PT"));
        return formatoMoeda.format(preco);
    }
}
