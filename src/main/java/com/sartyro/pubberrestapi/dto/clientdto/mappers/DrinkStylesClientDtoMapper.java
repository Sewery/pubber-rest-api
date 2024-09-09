package com.sartyro.pubberrestapi.dto.clientdto.mappers;

import com.sartyro.pubberrestapi.dto.clientdto.DrinkStylesClientDto;
import com.sartyro.pubberrestapi.model.DrinkStyles;

import java.util.Collections;
import java.util.List;

public class DrinkStylesClientDtoMapper {
    private DrinkStylesClientDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<DrinkStylesClientDto> mapToDtoList(List<DrinkStyles> drinkStyles)
    {
        return drinkStyles==null? Collections.emptyList():drinkStyles.stream()
                .map(DrinkStylesClientDtoMapper::mapToDto)
                .toList();
    }
    public static DrinkStylesClientDto mapToDto(DrinkStyles drinkStyles)
    {
        return new DrinkStylesClientDto(drinkStyles.getStyleName());
    }
}
