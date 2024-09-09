package com.sartyro.pubberrestapi.dto.editdto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

import static com.sartyro.pubberrestapi.util.Constants.EMPTY_ID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpeningHoursEditRequestDto {
    @PositiveOrZero
    @JsonIgnore
    private Long id;
    @NotBlank
    private String weekday;
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Schema(type = "String", pattern = "HH:mm")
    private LocalTime timeOpen;
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Schema(type = "String", pattern = "HH:mm")
    private LocalTime timeClose;
}
