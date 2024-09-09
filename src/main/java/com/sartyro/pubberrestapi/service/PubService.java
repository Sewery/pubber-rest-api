package com.sartyro.pubberrestapi.service;

import com.sartyro.pubberrestapi.dto.clientdto.PubClientDto;
import com.sartyro.pubberrestapi.dto.clientdto.mappers.PubClientDtoMapper;
import com.sartyro.pubberrestapi.dto.editdto.mapppers.PubDtoMapper;
import com.sartyro.pubberrestapi.dto.editdto.request.PubEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.PubEditResponseDto;
import com.sartyro.pubberrestapi.exception.EntityIdNotFoundException;
import com.sartyro.pubberrestapi.exception.NullFieldException;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.Pub;
import com.sartyro.pubberrestapi.model.Ratings;
import com.sartyro.pubberrestapi.repository.DrinkRepository;
import com.sartyro.pubberrestapi.repository.PubRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PubService {
    private final PubRepository pubRepository;
    private final DrinkRepository drinkRepository;
    public List<PubClientDto> getPubDtoListOptimized()
    {
        List<Pub> pubs =pubRepository.findAllPubsFetchOpeningHours();
        //pubRepository.findAllPubsFetchPhotos();
        //pubRepository.findAllPubsFetchRating();
        pubRepository.findAllPubsFetchDrinks();
        return PubClientDtoMapper.mapToDtoList(pubs);
    }
    public List<PubClientDto> getPubDtoList()
    {
        return PubClientDtoMapper.mapToDtoList(pubRepository.findAll());
    }
    public PubEditResponseDto getPubById(Long id)
    {
        return PubDtoMapper.fromEntityToResponse( pubRepository
                .findById(id)
                .orElseThrow(()->new EntityIdNotFoundException(Pub.class,id))
        );
    }
    @Transactional
    public List<Drink> fetchDrinks(PubEditRequestDto pubEditRequestDto){
        List<Drink> drinkEntityList = new ArrayList<>();
        if(pubEditRequestDto.getDrinksIDs()==null){
            return Collections.emptyList();
        }
        for( var id: pubEditRequestDto.getDrinksIDs()){
            drinkEntityList.add(
                    drinkRepository
                            .findById(id)
                            .orElseThrow(()->new EntityIdNotFoundException(Drink.class,id))
            );
        }
        return drinkEntityList;
    }
    @Transactional
    public PubEditResponseDto addPub(PubEditRequestDto pub)
    {
        List<Drink> drinks = fetchDrinks(pub);
        return PubDtoMapper.fromEntityToResponse(
                pubRepository.save(
                        PubDtoMapper.fromRequestToEntity(pub, drinks)
                )
        );
    }
    @Transactional
    public PubEditResponseDto editPub(PubEditRequestDto pubRequest)
    {
        //1. Checking if request dto is correct
        if(pubRequest==null || pubRequest.getId()==null){
            throw new NullFieldException(Pub.class,"id");
        }
        //2. Mapping request dto to entity
        Pub edited=pubRepository
                .findById(pubRequest.getId())
                .orElseThrow(()->new EntityIdNotFoundException(Pub.class,pubRequest.getId()));
        Pub mapped=PubDtoMapper.fromRequestToEntity(pubRequest, fetchDrinks(pubRequest));
        //5. Changing fields
        edited.setName(mapped.getName());
        edited.setAddress(mapped.getAddress());
        edited.setGeoLocation(mapped.getGeoLocation());
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
        return PubDtoMapper.fromEntityToResponse(edited);
    }
    //If filed is null or none present it's not changed, otherwise it's patched
    @Transactional
    public PubEditResponseDto patchPub(PubEditRequestDto pubRequest)
    {
        //1. Checking if request dto is correct
        if(pubRequest==null || pubRequest.getId()==null){
            throw new NullFieldException(Pub.class,"id");
        }
        //2. Mapping request dto to entity
        Pub mappedPubRequest =PubDtoMapper.fromRequestToEntity(pubRequest,null);

        //3. Retrieving pub by id from db
        Pub pubPatched=pubRepository
                .findById(pubRequest.getId())
                .orElseThrow(()->new EntityIdNotFoundException(Pub.class,pubRequest.getId()));

        //4. Changing drinks if requested
        if(pubRequest.getDrinksIDs()!=null){
            pubPatched.setDrinks(fetchDrinks(pubRequest));
        }

        //5. Changing other fields if requested
        if(mappedPubRequest.getName()!=null) {
            pubPatched .setName(mappedPubRequest.getName());
        }
        if(mappedPubRequest.getCity()!=null) {
            pubPatched.setCity(mappedPubRequest.getCity());
        }
        if(mappedPubRequest.getReservable()!=null) {
            pubPatched.setReservable(mappedPubRequest.getReservable());
        }
        if(mappedPubRequest.getTakeout()!=null) {
            pubPatched.setTakeout(mappedPubRequest.getTakeout());
        }
        if(mappedPubRequest.getAddress()!=null) {
            pubPatched.setAddress(mappedPubRequest.getAddress());
        }
        if(mappedPubRequest.getDrinks()!=null) {
            pubPatched.setDrinks(mappedPubRequest.getDrinks());
        }
        if(mappedPubRequest.getOpeningHours()!=null) {
            pubPatched.setOpeningHours(mappedPubRequest.getOpeningHours());
        }
        if(mappedPubRequest.getPhotos()!=null) {
            pubPatched.setPhotos(mappedPubRequest.getPhotos());
        }
        if(mappedPubRequest.getDescription()!=null) {
            pubPatched.setDescription(mappedPubRequest.getDescription());
        }
        if(pubRequest.getLatitude()!=null) {
            pubPatched.getGeoLocation().setLatitude(pubRequest.getLatitude());
        }
        if(pubRequest.getLongitude()!=null) {
            pubPatched.getGeoLocation().setLongitude(pubRequest.getLongitude());
        }
        if(mappedPubRequest.getPlaceId()!=null) {
            pubPatched.setPlaceId(mappedPubRequest.getPlaceId());
        }
        if(mappedPubRequest.getName()!=null) {
            pubPatched.setWebsiteUrl(mappedPubRequest.getWebsiteUrl());
        }
        if(mappedPubRequest.getPhoneNumber()!=null) {
            pubPatched.setPhoneNumber(mappedPubRequest.getPhoneNumber());
        }
        if(mappedPubRequest.getIconUrl()!=null) {
            pubPatched.setIconUrl(mappedPubRequest.getIconUrl());
        }
        if(mappedPubRequest.getRating()!=null) {
            Ratings ratings=mappedPubRequest.getRating();
            if(ratings.getGoogle()!=null) {
                pubPatched.getRating().setGoogle(ratings.getGoogle());
            }
            if(ratings.getGoogleCount()!=null) {
                pubPatched.getRating().setGoogleCount(ratings.getGoogleCount());
            }
            if(ratings.getFacebook()!=null) {
                pubPatched.getRating().setFacebook(ratings.getFacebook());
            }
            if(ratings.getFacebookCount()!=null) {
                pubPatched.getRating().setFacebookCount(ratings.getFacebookCount());
            }
            if(ratings.getUntapped()!=null) {
                pubPatched.getRating().setUntapped(ratings.getUntapped());
            }
            if(ratings.getUntappedCount()!=null) {
                pubPatched.getRating().setUntappedCount(ratings.getUntappedCount());
            }
            if(ratings.getTripAdvisor()!=null) {
                pubPatched.getRating().setTripAdvisor(ratings.getTripAdvisor());
            }
            if(ratings.getTripAdvisorCount()!=null) {
                pubPatched.getRating().setTripAdvisorCount(ratings.getTripAdvisorCount());
            }
            if(ratings.getOurDrinkQuality()!=null) {
                pubPatched.getRating().setOurDrinkQuality(ratings.getOurDrinkQuality());
            }
            if(ratings.getOurServiceQuality()!=null) {
                pubPatched.getRating().setOurServiceQuality(ratings.getOurServiceQuality());
            }
            if(ratings.getOurCost()!=null) {
                pubPatched.getRating().setOurCost(ratings.getOurCost());
            }
        }
        return PubDtoMapper.fromEntityToResponse(pubRepository.save(pubPatched));
    }
    public void deletePub(Long id)
    {
        pubRepository.deleteById(id);
    }
}
