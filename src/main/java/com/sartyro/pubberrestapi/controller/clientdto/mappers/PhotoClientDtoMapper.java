package com.sartyro.pubberrestapi.controller.clientdto.mappers;

import com.sartyro.pubberrestapi.controller.clientdto.PhotoClientDto;
import com.sartyro.pubberrestapi.model.Photo;

import java.util.List;

public class PhotoClientDtoMapper {
    public static List<PhotoClientDto> mapToDtoList(List<Photo> photos)
    {
        return null==photos?null:photos.stream()
                .map(PhotoClientDtoMapper::mapToDto)
                .toList();
    }
    public static PhotoClientDto mapToDto(Photo photo)
    {
        return PhotoClientDto.builder()
                .photoUrl(photo.getPhotoUrl())
                .title(photo.getTitle())
                .build();
    }
}
