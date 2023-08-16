package com.sartyro.pubberrestapi.controller.editdto.mappers;

import com.sartyro.pubberrestapi.controller.editdto.PhotoEditDto;
import com.sartyro.pubberrestapi.model.Photo;

import java.util.List;

public class PhotoEditDtoMapper {
    public static List<PhotoEditDto> mapToDtoList(List<Photo> photos)
    {
        return photos.stream()
                .map(PhotoEditDtoMapper::mapToDto)
                .toList();
    }
    public static PhotoEditDto mapToDto(Photo photo)
    {
        return PhotoEditDto.builder()
                .id(photo.getId())
                .photoUrl(photo.getPhotoUrl())
                .title(photo.getTitle())
                .build();
    }
    public static List<Photo> mapToEntityList(List<PhotoEditDto> photos)
    {
        return photos.stream()
                .map(PhotoEditDtoMapper::mapToEntity)
                .toList();
    }
    public static Photo mapToEntity(PhotoEditDto photo)
    {
        return new Photo(photo.getId(),null, photo.getTitle(), photo.getPhotoUrl());
    }
}
