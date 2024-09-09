package com.sartyro.pubberrestapi.dto.clientdto;

import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;


@Builder
@Getter
public class PhotoClientDto {
    @NotBlank
    private String title;
    @NotBlank
    private String photoUrl;
}
