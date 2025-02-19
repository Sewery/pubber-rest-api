package com.sartyro.pubberrestapi.dto.clientdto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BeerClientDto {
    private Long beerId;
    private String longDescription;
    private String shortDescription;
    private String photoUrl;
    private String maltiness;
    private String blg;
    private String alcoholContent;
}
