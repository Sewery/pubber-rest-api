package com.sartyro.pubberrestapi.controller.editdto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class DrinkEditDto {
    public final static Long EMPTY_ID=0L;
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
}
