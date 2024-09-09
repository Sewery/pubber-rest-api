package com.sartyro.pubberrestapi.dto.editdto.mapppers;

import com.sartyro.pubberrestapi.dto.editdto.request.PhotoEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.PhotoEditResponseDto;
import com.sartyro.pubberrestapi.model.Photo;
import com.sartyro.pubberrestapi.model.Pub;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PhotoDtoMapper {
    private PhotoDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static Photo fromRequestToEntity(PhotoEditRequestDto request, Pub pub) {
        return new Photo(
                request.getId(),
                request.getTitle(),
                request.getPhotoUrl(),
                pub
        );
    }
    // Map from request DTO to entity
    public static Photo fromRequestToEntity(PhotoEditRequestDto request) {
        return new Photo(
            request.getId(),
            request.getTitle(),
            request.getPhotoUrl(),
                null
        );
    }

    // Map from entity to response DTO
    public static PhotoEditResponseDto fromEntityToResponse(Photo entity) {
        if(entity==null)
            return null;
        return new PhotoEditResponseDto(
            entity.getId(),
            entity.getTitle(),
            entity.getPhotoUrl()
        );
    }

    // Map list of request DTOs to list of entities
    public static List<Photo> fromRequestListToEntityList(List<PhotoEditRequestDto> requestList) {
        if(requestList==null)
            return Collections.emptyList();
        return requestList.stream()
                          .map(PhotoDtoMapper::fromRequestToEntity)
                          .collect(Collectors.toList());
    }

    // Map list of entities to list of response DTOs
    public static List<PhotoEditResponseDto> fromEntityListToResponseList(List<Photo> entityList) {
        if(entityList==null)
            return Collections.emptyList();
        return entityList.stream()
                         .map(PhotoDtoMapper::fromEntityToResponse)
                         .collect(Collectors.toList());
    }
}
