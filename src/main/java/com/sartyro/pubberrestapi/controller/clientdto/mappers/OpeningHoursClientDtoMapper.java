package com.sartyro.pubberrestapi.controller.clientdto.mappers;

import com.sartyro.pubberrestapi.controller.clientdto.OpeningHoursClientDto;
import com.sartyro.pubberrestapi.model.OpeningHours;

import java.util.List;

public class OpeningHoursClientDtoMapper {
    private OpeningHoursClientDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<OpeningHoursClientDto> mapToDtoList(List<OpeningHours> openingHours)
    {
        return null==openingHours?null:openingHours.stream()
                .map(OpeningHoursClientDtoMapper::mapToDto)
                .toList();
    }
    public static OpeningHoursClientDto mapToDto(OpeningHours openingHours)
    {
        return OpeningHoursClientDto.builder()
                .weekday(openingHours.getWeekday())
                .timeOpen(openingHours.getTimeOpen())
                .timeClose(openingHours.getTimeClose())
                .build();
    }
}
