package com.sartyro.pubberrestapi.dto.editdto.mapppers;

import com.sartyro.pubberrestapi.dto.editdto.request.DrinkEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.DrinkEditResponseDto;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.DrinkStyles;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DrinkDtoMapper {
    private DrinkDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    // Map from request DTO to entity
    public static Drink fromRequestToEntity(DrinkEditRequestDto request) {
        if(request==null)
            return null;
        return new Drink(
            request.getId(),
            request.getName(),
            request.getType(),
            request.getDescription(),
            BeerDtoMapper.fromRequestToEntity(request.getBeer()),
            null,  // Assuming pubs and drinkStyles are managed separately
            null
        );
    }
    public static Drink fromRequestToEntity(DrinkEditRequestDto request, List<DrinkStyles> drinkStyles) {
        if(request==null)
            return null;
        return new Drink(
                request.getId(),
                request.getName(),
                request.getType(),
                request.getDescription(),
                BeerDtoMapper.fromRequestToEntity(request.getBeer()),
                null,  // Assuming pubs and drinkStyles are managed separately
                drinkStyles
        );
    }

    // Map from entity to response DTO
    public static DrinkEditResponseDto fromEntityToResponse(Drink entity) {
        if(entity==null)
            return null;
        return new DrinkEditResponseDto(
            entity.getId(),
            entity.getName(),
            entity.getType(),
            entity.getDescription(),
                BeerDtoMapper.fromEntityToResponse(entity.getBeer()),
            DrinkStylesDtoMapper.fromEntityListToResponseList(entity.getDrinkStyles())
        );
    }


    // Map list of request DTOs to list of entities
    public static List<Drink> fromRequestListToEntityList(List<DrinkEditRequestDto> requestList) {
        if(requestList==null)
            return Collections.emptyList();
        return requestList.stream()
                          .map(DrinkDtoMapper::fromRequestToEntity)
                          .collect(Collectors.toList());
    }

    // Map list of entities to list of response DTOs
    public static List<DrinkEditResponseDto> fromEntityListToResponseList(List<Drink> entityList) {
        if(entityList==null)
            return Collections.emptyList();
        return entityList.stream()
                         .map(DrinkDtoMapper::fromEntityToResponse)
                         .collect(Collectors.toList());
    }
}
