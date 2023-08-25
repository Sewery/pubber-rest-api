package com.sartyro.pubberrestapi.service;


import com.sartyro.pubberrestapi.controller.editdto.PhotoEditDto;
import com.sartyro.pubberrestapi.controller.editdto.mappers.PhotoEditDtoMapper;
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
        return PhotoEditDtoMapper.mapToDto(photoRepository.findById(id).orElseThrow());
    }
    public PhotoEditDto addPhoto(PhotoEditDto drink, Long pubId)
    {
        Pub pub= pubRepository.findById(pubId).orElseThrow();
        return PhotoEditDtoMapper.mapToDto(photoRepository.save(PhotoEditDtoMapper.mapToEntity(drink,pub)));
    }
    @Transactional
    public PhotoEditDto editPhoto(PhotoEditDto drink)
    {
        Photo edited=photoRepository.findById(drink.getId()).orElseThrow();
        edited.setId(drink.getId());
        edited.setPhotoUrl(drink.getPhotoUrl());
        edited.setTitle(drink.getTitle());
        photoRepository.save(edited);
        return PhotoEditDtoMapper.mapToDto(edited);
    }
    public void deletePhoto(Long id)
    {
        photoRepository.deleteById(id);
    }
}
