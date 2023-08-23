package com.sartyro.pubberrestapi.controller.editdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

import java.time.LocalTime;

@Builder
@Getter
@Setter
public class OpeningHoursEditDto {
    public final static Long EMPTY_ID=0L;
    @NotBlank
    private Long id;
    @NotBlank
    private String weekday;
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timeOpen;
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timeClose;
}
