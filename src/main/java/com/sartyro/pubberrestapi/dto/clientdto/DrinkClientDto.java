package com.sartyro.pubberrestapi.dto.clientdto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Builder
@Getter
public class DrinkClientDto {
    @Positive
    @NotNull
    private Long drinkId;

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotBlank
    private String description;

    private List<DrinkStylesClientDto> drinkStyles;

    private BeerClientDto beer;
}
