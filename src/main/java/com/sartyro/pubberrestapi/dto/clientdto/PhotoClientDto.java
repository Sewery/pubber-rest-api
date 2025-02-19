package com.sartyro.pubberrestapi.dto.clientdto;

import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;


@Builder
@Getter
public class PhotoClientDto {
    private String title;
    private String photoUrl;
}
