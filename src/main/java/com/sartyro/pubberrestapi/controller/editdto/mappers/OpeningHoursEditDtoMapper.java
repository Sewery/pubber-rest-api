package com.sartyro.pubberrestapi.controller.editdto.mappers;

import com.sartyro.pubberrestapi.controller.editdto.OpeningHoursEditDto;
import com.sartyro.pubberrestapi.model.OpeningHours;

import java.util.List;

public class OpeningHoursEditDtoMapper {
    public static List<OpeningHoursEditDto> mapToDtoList(List<OpeningHours> openingHours)
    {
        return openingHours.stream()
                .map(OpeningHoursEditDtoMapper::mapToDto)
                .toList();
    }
    public static OpeningHoursEditDto mapToDto(OpeningHours openingHours)
    {
        return OpeningHoursEditDto.builder()
                .id(openingHours.getId())
                .weekday(openingHours.getWeekday())
                .timeOpen(openingHours.getTimeOpen())
                .timeClose(openingHours.getTimeClose())
                .build();
    }
    public static List<OpeningHours> mapToEntityList(List<OpeningHoursEditDto> openingHours)
    {
        return openingHours.stream()
                .map(OpeningHoursEditDtoMapper::mapToEntity)
                .toList();
    }
    public static OpeningHours mapToEntity(OpeningHoursEditDto openingHours)
    {
        return new OpeningHours(openingHours.getId(), openingHours.getWeekday(), openingHours.getTimeOpen(),openingHours.getTimeClose(),null);
    }
}
