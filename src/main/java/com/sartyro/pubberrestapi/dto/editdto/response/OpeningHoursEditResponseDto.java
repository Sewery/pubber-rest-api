package com.sartyro.pubberrestapi.dto.editdto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalTime;

public record OpeningHoursEditResponseDto(
        Long id,
        String weekday,
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")   @Schema(type = "String", pattern = "HH:mm") LocalTime timeOpen,
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")   @Schema(type = "String", pattern = "HH:mm") LocalTime timeClose
) {
}

