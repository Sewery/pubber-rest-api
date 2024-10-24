package com.sartyro.pubberrestapi.dto.editdto.response;

public record BeerEditResponseDto(
        Long beerId,
        String longDescription,
        String shortDescription,
        String photoUrl,
        String maltiness,
        String blg,
        String alcoholContent
) {
}
