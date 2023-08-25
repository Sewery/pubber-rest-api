package com.sartyro.pubberrestapi.controller.editdto.mappers;

import com.sartyro.pubberrestapi.controller.editdto.OpeningHoursEditDto;
import com.sartyro.pubberrestapi.model.OpeningHours;
import com.sartyro.pubberrestapi.model.Pub;

import java.util.ArrayList;
import java.util.List;

public class OpeningHoursEditDtoMapper {
    public static List<OpeningHoursEditDto> mapToDtoList(List<OpeningHours> openingHours)
    {
        return openingHours==null?null:new ArrayList<>(openingHours.stream()
                .map(OpeningHoursEditDtoMapper::mapToDto)
                .toList());
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
        return openingHours==null?null:new ArrayList<>(openingHours.stream()
                .map(o->OpeningHoursEditDtoMapper.mapToEntity(o,null))
                .toList());
    }
    public static OpeningHours mapToEntity(OpeningHoursEditDto openingHours, Pub pub)
    {
        return new OpeningHours(openingHours.getId(), openingHours.getWeekday(), openingHours.getTimeOpen(),openingHours.getTimeClose(),pub);
    }
}
