package com.sartyro.pubberrestapi.controller.editdto;

import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Builder
@Getter
public class PhotoEditDto {
    public final static Long EMPTY_ID=0L;
    @NotBlank
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String photoUrl;
}
