package com.sartyro.pubberrestapi.controller.editdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalTime;

@Builder
@Getter
public class OpeningHoursEditDto {
    public final static Long EMPTY_ID=0L;
    @NotBlank
    private Long id;
    @NotBlank
    private String weekday;
    @NotBlank
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timeOpen;
    @NotBlank
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timeClose;
}
