package com.sartyro.pubberrestapi.controller.editdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Builder
@Data
public class DrinkEditDto {
    public final static Long EMPTY_ID=0L;
    @PositiveOrZero
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotBlank
    private String description;
    private List<DrinkStylesEditDto> drinkStyles;
}
