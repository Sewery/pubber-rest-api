package com.sartyro.pubberrestapi.controller.editdto.mappers;

import com.sartyro.pubberrestapi.controller.editdto.PhotoEditDto;
import com.sartyro.pubberrestapi.model.Photo;
import com.sartyro.pubberrestapi.model.Pub;

import java.util.ArrayList;
import java.util.List;

public class PhotoEditDtoMapper {
    private PhotoEditDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<PhotoEditDto> mapToDtoList(List<Photo> photos)
    {
        return photos==null?null:new ArrayList<>(photos.stream()
                .map(PhotoEditDtoMapper::mapToDto)
                .toList());
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
        return photos==null?null:new ArrayList<>(photos.stream()
                .map(p->PhotoEditDtoMapper.mapToEntity(p,null))
                .toList());
    }
    public static Photo mapToEntity(PhotoEditDto photo, Pub pub)
    {
        return new Photo(photo.getId(),pub, photo.getTitle(), photo.getPhotoUrl());
    }
}
