package com.sartyro.pubberrestapi.controller.editdto.mappers;

import com.sartyro.pubberrestapi.controller.editdto.DrinkEditDto;
import com.sartyro.pubberrestapi.model.Drink;

import java.util.ArrayList;
import java.util.List;

public class DrinkEditDtoMapper {
    private DrinkEditDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<DrinkEditDto> mapToDtoList(List<Drink> drink)
    {
        return drink==null?null:new ArrayList<>(drink.stream()
                .map(DrinkEditDtoMapper::mapToDto)
                .toList());
    }
    public static DrinkEditDto mapToDto(Drink drink)
    {
        return DrinkEditDto.builder()
                .id(drink.getId())
                .type(drink.getType())
                .name(drink.getName())
                .description(drink.getDescription())
                .drinkStyles(DrinkStylesEditDtoMapper.mapToDtoList(drink.getDrinkStyles()))
                .build();
    }
    public static List<Drink> mapToEntityList(List<DrinkEditDto> drink)
    {
        return drink==null?null:new ArrayList<>(drink.stream()
                .map(DrinkEditDtoMapper::mapToEntity)
                .toList());
    }
    public static Drink mapToEntity(DrinkEditDto drink)
    {
        return new Drink(drink.getId(),drink.getName(),drink.getType(), drink.getDescription(), null,
                DrinkStylesEditDtoMapper.mapToEntityList(drink.getDrinkStyles()));
    }
}
