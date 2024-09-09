package com.sartyro.pubberrestapi.dto.clientdto.mappers;

import com.sartyro.pubberrestapi.dto.clientdto.PubClientDto;
import com.sartyro.pubberrestapi.model.Pub;

import java.util.List;

public class PubClientDtoMapper {
    private PubClientDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }

    public static List<PubClientDto> mapToDtoList(List<Pub> pubs)
    {
        return pubs.stream()
                .map(PubClientDtoMapper::mapToDto)
                .toList();
    }

    public static PubClientDto mapToDto(Pub pub)
    {
        return PubClientDto.builder()
                .id(pub.getId())
                .name(pub.getName())
                .placeId(pub.getPlaceId())
                .city(pub.getCity())
                .address(pub.getAddress())
                .city(pub.getCity())
                .websiteUrl(pub.getWebsiteUrl())
                .phoneNumber(pub.getPhoneNumber())
                .description(pub.getDescription())
                .latitude(pub.getGeoLocation()==null?null:pub.getGeoLocation().getLatitude())
                .longitude(pub.getGeoLocation()==null?null:pub.getGeoLocation().getLongitude())
                .iconUrl(pub.getIconUrl())
                .reservable(pub.getReservable())
                .takeout(pub.getReservable())
                .drinks(DrinkClientDtoMapper.mapToDtoList(pub.getDrinks()))
                .openingHours(OpeningHoursClientDtoMapper.mapToDtoList(pub.getOpeningHours()))
                .ratings(RatingsClientDtoMapper.mapToDto(pub.getRating()))
                .photos(PhotoClientDtoMapper.mapToDtoList(pub.getPhotos()))
                .tags(TagClientDtoMapper.mapToDtoList(pub.getTags()))
                .build();
    }
}
