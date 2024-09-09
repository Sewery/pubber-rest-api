package com.sartyro.pubberrestapi.dto.clientdto;

import lombok.Builder;

import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Builder
@Getter
public class DrinkClientDto {
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotBlank
    private String description;
    private List<DrinkStylesClientDto> drinkStyles;
}
