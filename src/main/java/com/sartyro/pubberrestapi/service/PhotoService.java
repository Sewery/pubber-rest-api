package com.sartyro.pubberrestapi.service;


import com.sartyro.pubberrestapi.controller.editdto.PhotoEditDto;
import com.sartyro.pubberrestapi.controller.editdto.mappers.PhotoEditDtoMapper;
import com.sartyro.pubberrestapi.exception.EntityIdNotFoundException;
import com.sartyro.pubberrestapi.exception.NullFieldException;
import com.sartyro.pubberrestapi.model.OpeningHours;
import com.sartyro.pubberrestapi.model.Photo;
import com.sartyro.pubberrestapi.model.Pub;
import com.sartyro.pubberrestapi.repository.PhotoRepository;
import com.sartyro.pubberrestapi.repository.PubRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final PubRepository pubRepository;
    public List<PhotoEditDto> getPhotos()
    {
        return PhotoEditDtoMapper.mapToDtoList(StreamSupport.stream(photoRepository.findAll().spliterator(),false)
                .toList());
    }
    public PhotoEditDto getPhoto(Long id)
    {
        return PhotoEditDtoMapper.mapToDto(photoRepository.findById(id)
                .orElseThrow(()->new EntityIdNotFoundException(Photo.class,id)));
    }
    public PhotoEditDto addPhoto(PhotoEditDto photo, Long pubId)
    {
        Pub pub= pubRepository.findById(pubId)
                .orElseThrow(()->new EntityIdNotFoundException(Pub.class,pubId));
        return PhotoEditDtoMapper.mapToDto(photoRepository.save(PhotoEditDtoMapper.mapToEntity(photo,pub)));
    }
    @Transactional
    public PhotoEditDto editPhoto(PhotoEditDto photo)
    {
        if(photo==null || photo.getId()==null){
            throw new NullFieldException(Photo.class,"id");
        }
        Photo edited=photoRepository.findById(photo.getId())
                .orElseThrow(()->new EntityIdNotFoundException(Photo.class,photo.getId()));
        edited.setId(photo.getId());
        edited.setPhotoUrl(photo.getPhotoUrl());
        edited.setTitle(photo.getTitle());
        photoRepository.save(edited);
        return PhotoEditDtoMapper.mapToDto(edited);
    }
    public void deletePhoto(Long id)
    {
        photoRepository.deleteById(id);
    }
}
