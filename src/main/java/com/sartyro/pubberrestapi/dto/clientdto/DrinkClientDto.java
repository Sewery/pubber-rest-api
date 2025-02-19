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
    private Long drinkId;

    private String name;

    private String type;

    private String description;

    private List<DrinkStylesClientDto> drinkStyles;

    private BeerClientDto beer;
}
