package com.sartyro.pubberrestapi.dto.editdto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

import static com.sartyro.pubberrestapi.util.Constants.EMPTY_ID;

public record DrinkStylesEditResponseDto(
        Long id,
        String styleName
) {
}
