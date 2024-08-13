package com.sartyro.pubberrestapi.controller.clientdto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DrinkStylesClientDto {
    @NotBlank
    private String styleName;
}
