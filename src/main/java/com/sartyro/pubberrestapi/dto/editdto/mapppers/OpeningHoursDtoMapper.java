package com.sartyro.pubberrestapi.dto.editdto.mapppers;

import com.sartyro.pubberrestapi.dto.editdto.request.OpeningHoursEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.OpeningHoursEditResponseDto;
import com.sartyro.pubberrestapi.model.OpeningHours;
import com.sartyro.pubberrestapi.model.Pub;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OpeningHoursDtoMapper {
    private OpeningHoursDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static OpeningHours fromRequestToEntity(OpeningHoursEditRequestDto request, Pub pub) {
        if(request==null)
            return null;
        return new OpeningHours(
                request.getId(),
                request.getWeekday(),
                request.getTimeOpen(),
                request.getTimeClose(),
                pub
        );
    }
    // Map from request DTO to entity
    public static OpeningHours fromRequestToEntity(OpeningHoursEditRequestDto request) {
        if(request==null)
            return null;
        return new OpeningHours(
            request.getId(),
            request.getWeekday(),
            request.getTimeOpen(),
            request.getTimeClose(),
                null
        );
    }

    // Map from entity to response DTO
    public static OpeningHoursEditResponseDto fromEntityToResponse(OpeningHours entity) {
        if(entity==null)
            return null;
        return new OpeningHoursEditResponseDto(
            entity.getId(),
            entity.getWeekday(),
            entity.getTimeOpen(),
            entity.getTimeClose()
        );
    }

    // Map list of request DTOs to list of entities
    public static List<OpeningHours> fromRequestListToEntityList(List<OpeningHoursEditRequestDto> requestList) {
        if(requestList==null)
            return Collections.emptyList();
        return requestList.stream()
                          .map(OpeningHoursDtoMapper::fromRequestToEntity)
                          .collect(Collectors.toList());
    }

    // Map list of entities to list of response DTOs
    public static List<OpeningHoursEditResponseDto> fromEntityListToResponseList(List<OpeningHours> entityList) {
        if(entityList==null)
            return Collections.emptyList();
        return entityList.stream()
                         .map(OpeningHoursDtoMapper::fromEntityToResponse)
                         .collect(Collectors.toList());
    }
}
