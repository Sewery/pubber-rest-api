package com.sartyro.pubberrestapi.dto.editdto.mapppers;

import com.sartyro.pubberrestapi.dto.editdto.request.PubEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.PubEditResponseDto;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.Geolocation;
import com.sartyro.pubberrestapi.model.Pub;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PubDtoMapper {
    private PubDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    // Map from request DTO to entity
    public static Pub fromRequestToEntity(PubEditRequestDto request) {
        if(request==null)
            return null;
        return new Pub(
            request.getId(),
            request.getName(),
            request.getAddress(),
            request.getPlaceId(),
            request.getCity(),
            request.getPhoneNumber(),
            request.getWebsiteUrl(),
            request.getIconUrl(),
            request.getDescription(),
            new Geolocation(
                    request.getLatitude(),
                    request.getLongitude()
            ),
            request.getReservable(),
            request.getTakeout(),
            RatingsDtoMapper.fromRequestToEntity(request.getRatings()),  // Assuming Ratings and other lists (OpeningHours, Drinks) are handled separately
            null,
            null,
            null,
            null
        );
    }
    // Map from request DTO to entity
    public static Pub fromRequestToEntity(PubEditRequestDto request, List<Drink> drinks) {
        if(request==null)
            return null;
        return new Pub(
                request.getId(),
                request.getName(),
                request.getAddress(),
                request.getPlaceId(),
                request.getCity(),
                request.getPhoneNumber(),
                request.getWebsiteUrl(),
                request.getIconUrl(),
                request.getDescription(),
                new Geolocation(
                        request.getLatitude(),
                        request.getLongitude()
                ),
                request.getReservable(),
                request.getTakeout(),
                RatingsDtoMapper.fromRequestToEntity(request.getRatings()),  // Assuming Ratings and other lists (OpeningHours, Drinks) are handled separately
                null,
                drinks,
                null,
                null
        );
    }

    // Map from entity to response DTO
    public static PubEditResponseDto fromEntityToResponse(Pub entity) {
        if(entity==null)
            return null;
        return new PubEditResponseDto(
            entity.getId(),
            entity.getName(),
            entity.getAddress(),
            entity.getPlaceId(),
            entity.getCity(),
            entity.getPhoneNumber(),
            entity.getWebsiteUrl(),
            entity.getIconUrl(),
            entity.getDescription(),
            entity.getGeoLocation()==null?null:entity.getGeoLocation().getLatitude(),
            entity.getGeoLocation()==null?null:entity.getGeoLocation().getLongitude(),
            entity.getReservable(),
            entity.getTakeout(),
            RatingsDtoMapper.fromEntityToResponse(entity.getRating()),
            OpeningHoursDtoMapper.fromEntityListToResponseList(entity.getOpeningHours()),
            DrinkDtoMapper.fromEntityListToResponseList(entity.getDrinks()),
            PhotoDtoMapper.fromEntityListToResponseList(entity.getPhotos()),
            TagDtoMapper.fromEntityListToResponseList(entity.getTags())
        );
    }

    // Map list of request DTOs to list of entities
    public static List<Pub> fromRequestListToEntityList(List<PubEditRequestDto> requestList) {
        if(requestList==null)
            return Collections.emptyList();
        return requestList.stream()
                          .map(PubDtoMapper::fromRequestToEntity)
                          .collect(Collectors.toList());
    }

    // Map list of entities to list of response DTOs
    public static List<PubEditResponseDto> fromEntityListToResponseList(List<Pub> entityList) {
        if(entityList==null)
            return Collections.emptyList();
        return entityList.stream()
                         .map(PubDtoMapper::fromEntityToResponse)
                         .collect(Collectors.toList());
    }
}
