package com.sartyro.pubberrestapi.controller.editdto.mappers;

import com.sartyro.pubberrestapi.controller.editdto.*;
import com.sartyro.pubberrestapi.model.Pub;

import java.util.List;

public class PubEditDtoMapper {
    private PubEditDtoMapper() {}

    public static List<PubEditDto> mapToDtoList(List<Pub> pubs)
    {
        return pubs.stream()
                .map(PubEditDtoMapper::mapToDto)
                .toList();
    }

    public static PubEditDto mapToDto(Pub pub)
    {
        return PubEditDto.builder()
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
                .drinks(DrinkEditDtoMapper.mapToDtoList(pub.getDrinks()))
                .openingHours(OpeningHoursEditDtoMapper.mapToDtoList(pub.getOpeningHours()))
                .ratings(RatingsEditDtoMapper.mapToDto(pub.getRating()))
                .photos(PhotoEditDtoMapper.mapToDtoList(pub.getPhotos()))
                .build();
    }
    public static List<Pub> mapToPubList(List<PubEditDto> pubs)
    {
        return pubs.stream()
                .map(PubEditDtoMapper::mapToEntity)
                .toList();
    }
    public static Pub mapToEntity(PubEditDto pub)
    {
        return new Pub(null, pub.getPlaceId(),pub.getCity(), pub.getAddress(), pub.getName(),
                pub.getPhoneNumber(), pub.getWebsiteUrl(),
                pub.getIconUrl(), pub.getDescription(),
                pub.getReservable(),pub.getTakeout(),
               RatingsEditDtoMapper.mapToEntity(pub.getRatings()),OpeningHoursEditDtoMapper.mapToEntityList(pub.getOpeningHours()),
               DrinkEditDtoMapper.mapToEntityList(pub.getDrinks()),PhotoEditDtoMapper.mapToEntityList(pub.getPhotos()));
    }
}
