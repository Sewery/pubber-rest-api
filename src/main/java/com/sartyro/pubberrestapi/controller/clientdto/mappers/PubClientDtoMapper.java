package com.sartyro.pubberrestapi.controller.clientdto.mappers;

import com.sartyro.pubberrestapi.controller.clientdto.PubClientDto;
import com.sartyro.pubberrestapi.model.Pub;

import java.util.List;

public class PubClientDtoMapper {
    private PubClientDtoMapper() {}

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
                .websiteUrl(pub.getWebsiteUrl())
                .phoneNumber(pub.getPhoneNumber())
                .description(pub.getDescription())
                .iconUrl(pub.getIconUrl())
                .reservable(pub.getReservable())
                .takeout(pub.getReservable())
                .drinks(DrinkClientDtoMapper.mapToDtoList(pub.getDrinks()))
                .openingHours(OpeningHoursClientDtoMapper.mapToDtoList(pub.getOpeningHours()))
                .ratings(RatingsClientDtoMapper.mapToDto(pub.getRating()))
                .photos(PhotoClientDtoMapper.mapToDtoList(pub.getPhotos()))
                .build();
    }
}
