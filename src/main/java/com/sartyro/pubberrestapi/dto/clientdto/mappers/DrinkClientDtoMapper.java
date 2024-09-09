package com.sartyro.pubberrestapi.dto.clientdto.mappers;

import com.sartyro.pubberrestapi.dto.clientdto.DrinkClientDto;
import com.sartyro.pubberrestapi.model.Drink;

import java.util.Collections;
import java.util.List;

public class DrinkClientDtoMapper {
    private DrinkClientDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<DrinkClientDto> mapToDtoList(List<Drink> drink)
    {
        return drink==null? Collections.emptyList():drink.stream()
                .map(DrinkClientDtoMapper::mapToDto)
                .toList();
    }
    public static DrinkClientDto mapToDto(Drink drink)
    {
        return DrinkClientDto.builder()
                .type(drink.getType())
                .name(drink.getName())
                .description(drink.getDescription())
                .drinkStyles(DrinkStylesClientDtoMapper.mapToDtoList(drink.getDrinkStyles()))
                .build();
    }
}
