package com.sartyro.pubberrestapi.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

@Builder
@Getter
public class OpeningHoursClientDto {
    private String weekday;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timeOpen;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timeClose;
}
