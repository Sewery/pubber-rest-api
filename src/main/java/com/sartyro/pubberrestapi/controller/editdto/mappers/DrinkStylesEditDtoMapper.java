package com.sartyro.pubberrestapi.controller.editdto.mappers;

import com.sartyro.pubberrestapi.controller.editdto.DrinkEditDto;
import com.sartyro.pubberrestapi.controller.editdto.DrinkStylesEditDto;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.DrinkStyles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DrinkStylesEditDtoMapper {
    private DrinkStylesEditDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<DrinkStylesEditDto> mapToDtoList(List<DrinkStyles> drinkStyles)
    {
        return drinkStyles==null?null:new ArrayList<>(drinkStyles.stream()
                .map(DrinkStylesEditDtoMapper::mapToDto)
                .toList());
    }
    public static DrinkStylesEditDto mapToDto(DrinkStyles drinkStyle)
    {
        return DrinkStylesEditDto.builder()
                .id(drinkStyle.getId())
                .styleName(drinkStyle.getStyleName())
                .build();
    }
    public static List<DrinkStyles> mapToEntityList(List<DrinkStylesEditDto> drinkStyles)
    {
        return drinkStyles==null?null:new ArrayList<>(drinkStyles.stream()
                .map(DrinkStylesEditDtoMapper::mapToEntity)
                .toList());
    }
    public static DrinkStyles mapToEntity(DrinkStylesEditDto drink)
    {
        return new DrinkStyles(drink.getId(),drink.getStyleName(),null);
    }
}
