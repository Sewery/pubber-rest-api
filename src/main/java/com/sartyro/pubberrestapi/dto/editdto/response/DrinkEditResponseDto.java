package com.sartyro.pubberrestapi.dto.editdto.response;

import java.util.List;


public record DrinkEditResponseDto (
        Long id,
        String name,
        String type,
        String description,
        BeerEditResponseDto beer,
        List<DrinkStylesEditResponseDto> drinkStyles
){

}