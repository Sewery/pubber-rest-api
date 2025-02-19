package com.sartyro.pubberrestapi.dto.clientdto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DrinkStylesClientDto {
    private String styleName;
}
