package com.sartyro.pubberrestapi.dto.editdto.mapppers;

import com.sartyro.pubberrestapi.dto.editdto.request.DrinkStylesEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.DrinkStylesEditResponseDto;
import com.sartyro.pubberrestapi.model.DrinkStyles;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DrinkStylesDtoMapper {
    private DrinkStylesDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    // Map from request DTO to entity
    public static DrinkStyles fromRequestToEntity(DrinkStylesEditRequestDto request) {
        if(request == null)
            return null;
        return new DrinkStyles(
            request.getId(),
            request.getStyleName(),
            null  // Assuming drinks are managed separately
        );
    }
    // Map from entity to response DTO
    public static DrinkStylesEditResponseDto fromEntityToResponse(DrinkStyles entity) {
        if(entity == null)
            return null;
        return new DrinkStylesEditResponseDto(
            entity.getId(),
            entity.getStyleName()
        );
    }

    // Map list of request DTOs to list of entities
    public static List<DrinkStyles> fromRequestListToEntityList(List<DrinkStylesEditRequestDto> requestList) {
        if(requestList==null)
            return Collections.emptyList();
        return requestList.stream()
                          .map(DrinkStylesDtoMapper::fromRequestToEntity)
                          .collect(Collectors.toList());
    }

    // Map list of entities to list of response DTOs
    public static List<DrinkStylesEditResponseDto> fromEntityListToResponseList(List<DrinkStyles> entityList) {
        if(entityList==null)
            return Collections.emptyList();
        return entityList.stream()
                         .map(DrinkStylesDtoMapper::fromEntityToResponse)
                         .collect(Collectors.toList());
    }
}
