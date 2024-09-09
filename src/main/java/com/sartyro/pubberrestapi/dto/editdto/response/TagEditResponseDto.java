package com.sartyro.pubberrestapi.dto.editdto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

public record TagEditResponseDto(
        Long id,
        String name
) {
}
