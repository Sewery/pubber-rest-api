package com.sartyro.pubberrestapi.controller.clientdto;

import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Builder
@Getter
public class DrinkClientDto {
    @NotBlank
    private String name;
    @NotBlank
    private String type;
}
