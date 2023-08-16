package com.sartyro.pubberrestapi.service;

import com.sartyro.pubberrestapi.controller.clientdto.PubClientDto;
import com.sartyro.pubberrestapi.controller.clientdto.mappers.PubClientDtoMapper;
import com.sartyro.pubberrestapi.controller.editdto.PubEditDto;
import com.sartyro.pubberrestapi.controller.editdto.mappers.PubEditDtoMapper;
import com.sartyro.pubberrestapi.model.Pub;
import com.sartyro.pubberrestapi.repository.PubRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PubService {
    private final PubRepository pubRepository;

    public List<PubClientDto> getPubDtoListOptimized()
    {
        List<Pub> pubs =pubRepository.findAllPubsFetchOpeningHours();
        pubs =pubRepository.findAllPubsFetchPhotos();
        pubs =pubRepository.findAllPubsFetchRating();
        pubs =pubRepository.findAllPubsFetchDrinks();
        return PubClientDtoMapper.mapToDtoList(pubs);
    }
    public List<PubClientDto> getPubDtoList()
    {
        return PubClientDtoMapper.mapToDtoList(pubRepository.findAll());
    }
    public PubEditDto getSinglePub(Long id)
    {
        return PubEditDtoMapper.mapToDto( pubRepository.findById(id).orElseThrow());
    }
    public PubEditDto addPub(PubEditDto pub)
    {
        return PubEditDtoMapper.mapToDto(pubRepository.save(PubEditDtoMapper.mapToEntity(pub)));
    }
    @Transactional
    public PubEditDto editPub(PubEditDto pub)
    {
        Pub edited=pubRepository.findById(pub.getId()).orElseThrow();
        Pub mapped=PubEditDtoMapper.mapToEntity(pub);
        edited.setName(mapped.getName());
        edited.setAddress(mapped.getAddress());
        edited.setCity(mapped.getCity());
        edited.setReservable(mapped.getReservable());
        edited.setTakeout(mapped.getTakeout());
        edited.setDrinks(mapped.getDrinks());
        edited.setOpeningHours(mapped.getOpeningHours());
        edited.setPhotos(mapped.getPhotos());
        edited.setDescription(mapped.getDescription());
        edited.setPlaceId(mapped.getPlaceId());
        edited.setWebsiteUrl(mapped.getWebsiteUrl());
        edited.setPhoneNumber(mapped.getPhoneNumber());
        edited.setIconUrl(mapped.getIconUrl());
        edited.setRating(mapped.getRating());

        pubRepository.save(edited);
        return PubEditDtoMapper.mapToDto(edited);
    }
    @Transactional
    public PubEditDto patchPub(PubEditDto pub)
    {
        Pub patched=pubRepository.findById(pub.getId()).orElseThrow();
        Pub mapped =PubEditDtoMapper.mapToEntity(pub);
        if(mapped.getName()!=null) {
            patched .setName(mapped.getName());
        }
        if(mapped.getCity()!=null) {
            patched.setCity(mapped.getCity());
        }
        if(mapped.getReservable()!=null) {
            patched.setReservable(mapped.getReservable());
        }
        if(mapped.getTakeout()!=null) {
            patched.setTakeout(mapped.getTakeout());
        }
        if(mapped.getAddress()!=null) {
            patched.setAddress(mapped.getAddress());
        }
        if(mapped.getDrinks()!=null) {
            patched.setDrinks(mapped.getDrinks());
        }
        if(mapped.getOpeningHours()!=null) {
            patched.setOpeningHours(mapped.getOpeningHours());
        }
        if(mapped.getName()!=null) {
            patched.setPhotos(mapped.getPhotos());
        }
        if(mapped.getDescription()!=null) {
            patched.setDescription(mapped.getDescription());
        }
        if(mapped.getPlaceId()!=null) {
            patched.setPlaceId(mapped.getPlaceId());
        }
        if(mapped.getName()!=null) {
            patched.setWebsiteUrl(mapped.getWebsiteUrl());
        }
        if(mapped.getPhoneNumber()!=null) {
            patched.setPhoneNumber(mapped.getPhoneNumber());
        }
        if(mapped.getIconUrl()!=null) {
            patched.setIconUrl(mapped.getIconUrl());
        }
        if(mapped.getRating()!=null) {
            patched.setRating(mapped.getRating());
        }
        pubRepository.save(patched);
        return PubEditDtoMapper.mapToDto(patched);
    }
    public void deletePub(Long id)
    {
        pubRepository.deleteById(id);
    }
    //public Pub editPub(pub )
}
