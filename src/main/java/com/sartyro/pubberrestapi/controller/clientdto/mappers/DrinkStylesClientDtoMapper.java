package com.sartyro.pubberrestapi.controller.clientdto.mappers;

import com.sartyro.pubberrestapi.controller.clientdto.DrinkClientDto;
import com.sartyro.pubberrestapi.controller.clientdto.DrinkStylesClientDto;
import com.sartyro.pubberrestapi.controller.editdto.mappers.DrinkStylesEditDtoMapper;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.DrinkStyles;

import java.util.List;

public class DrinkStylesClientDtoMapper {
    private DrinkStylesClientDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<DrinkStylesClientDto> mapToDtoList(List<DrinkStyles> drinkStyles)
    {
        return drinkStyles==null?null:drinkStyles.stream()
                .map(DrinkStylesClientDtoMapper::mapToDto)
                .toList();
    }
    public static DrinkStylesClientDto mapToDto(DrinkStyles drinkStyles)
    {
        return new DrinkStylesClientDto(drinkStyles.getStyleName());
    }
}
