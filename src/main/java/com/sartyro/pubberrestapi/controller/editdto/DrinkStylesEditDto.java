package com.sartyro.pubberrestapi.controller.editdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DrinkStylesEditDto {
    public final static Long EMPTY_ID=0L;
    @PositiveOrZero(message ="Id field must be non negative integer")
    private Long id;
    @NotBlank(message = "Style name field can't be blank")
    private String styleName;
}
