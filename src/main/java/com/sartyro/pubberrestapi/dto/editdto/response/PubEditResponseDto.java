package com.sartyro.pubberrestapi.dto.editdto.response;

import java.util.List;

public record PubEditResponseDto(
        Long id,
        String name,
        String address,
        String placeId,
        String city,
        String phoneNumber,
        String websiteUrl,
        String iconUrl,
        String description,
        Double latitude,
        Double longitude,
        Boolean reservable,
        Boolean takeout,
        RatingsEditResponseDto ratings,
        List<OpeningHoursEditResponseDto> openingHours,
        List<DrinkEditResponseDto> drinks,
        List<PhotoEditResponseDto> photos,
        List<TagEditResponseDto> tags
) {

}
