package com.sartyro.pubberrestapi.service;


import com.sartyro.pubberrestapi.dto.editdto.mapppers.PhotoDtoMapper;
import com.sartyro.pubberrestapi.dto.editdto.request.PhotoEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.PhotoEditResponseDto;
import com.sartyro.pubberrestapi.exception.EntityIdNotFoundException;
import com.sartyro.pubberrestapi.exception.NullFieldException;
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
    public List<PhotoEditResponseDto> getPhotos()
    {
        return PhotoDtoMapper
                .fromEntityListToResponseList(StreamSupport
                        .stream(photoRepository.findAll().spliterator(), false)
                        .toList()
                );
    }
    public PhotoEditResponseDto getPhoto(Long id)
    {
        return PhotoDtoMapper.fromEntityToResponse(photoRepository
                .findById(id)
                .orElseThrow(()->new EntityIdNotFoundException(Photo.class,id))
        );
    }
    public PhotoEditResponseDto addPhoto(PhotoEditRequestDto photo, Long pubId)
    {
        Pub pub= pubRepository
                .findById(pubId)
                .orElseThrow(()->new EntityIdNotFoundException(Pub.class,pubId));
        return PhotoDtoMapper.fromEntityToResponse(photoRepository.save(PhotoDtoMapper.fromRequestToEntity(photo,pub)));
    }
    @Transactional
    public PhotoEditResponseDto editPhoto(PhotoEditRequestDto photo)
    {
        if(photo==null || photo.getId()==null){
            throw new NullFieldException(Photo.class,"id");
        }
        Photo edited=photoRepository
                .findById(photo.getId())
                .orElseThrow(()->new EntityIdNotFoundException(Photo.class,photo.getId()));
        edited.setId(photo.getId());
        edited.setPhotoUrl(photo.getPhotoUrl());
        edited.setTitle(photo.getTitle());
        photoRepository.save(edited);
        return PhotoDtoMapper.fromEntityToResponse(edited);
    }
    public void deletePhoto(Long id)
    {
        photoRepository.deleteById(id);
    }
}
