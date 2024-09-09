package com.sartyro.pubberrestapi.dto.editdto.mapppers;

import com.sartyro.pubberrestapi.dto.editdto.request.TagEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.TagEditResponseDto;
import com.sartyro.pubberrestapi.model.Pub;
import com.sartyro.pubberrestapi.model.Tag;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TagDtoMapper {
    private TagDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static Tag fromRequestToEntity(TagEditRequestDto request,Pub pub) {
        if(request==null)
            return null;
        return new Tag(
                request.getId(),
                request.getName(),
                pub
        );
    }
    // Map from request DTO to entity
    public static Tag fromRequestToEntity(TagEditRequestDto request) {
        if(request==null)
            return null;
        return new Tag(
            request.getId(),
            request.getName(),
                null
        );
    }

    // Map from entity to response DTO
    public static TagEditResponseDto fromEntityToResponse(Tag entity) {
        if(entity==null)
            return null;
        return new TagEditResponseDto(
            entity.getId(),
            entity.getName()
        );
    }

    // Map list of request DTOs to list of entities
    public static List<Tag> fromRequestListToEntityList(List<TagEditRequestDto> requestList) {
        if(requestList==null)
            return Collections.emptyList();
        return requestList.stream()
                          .map(TagDtoMapper::fromRequestToEntity)
                          .collect(Collectors.toList());
    }

    // Map list of entities to list of response DTOs
    public static List<TagEditResponseDto> fromEntityListToResponseList(List<Tag> entityList) {
        if(entityList==null)
            return Collections.emptyList();
        return entityList.stream()
                         .map(TagDtoMapper::fromEntityToResponse)
                         .collect(Collectors.toList());
    }
}
