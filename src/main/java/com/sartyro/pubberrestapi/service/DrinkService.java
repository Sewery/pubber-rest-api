package com.sartyro.pubberrestapi.service;

import com.sartyro.pubberrestapi.dto.editdto.mapppers.BeerDtoMapper;
import com.sartyro.pubberrestapi.dto.editdto.mapppers.DrinkDtoMapper;
import com.sartyro.pubberrestapi.dto.editdto.request.DrinkEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.DrinkEditResponseDto;
import com.sartyro.pubberrestapi.exception.EntityIdNotFoundException;
import com.sartyro.pubberrestapi.exception.NullFieldException;
import com.sartyro.pubberrestapi.model.Beer;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.DrinkStyles;
import com.sartyro.pubberrestapi.repository.DrinkRepository;
import com.sartyro.pubberrestapi.repository.DrinkStylesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.StreamSupport;


@Slf4j
@Service
@RequiredArgsConstructor
public class DrinkService {
    private final DrinkRepository drinkRepository;
    private final DrinkStylesRepository drinkStylesRepository;

    public List<DrinkEditResponseDto> getDrinks()
    {
        return DrinkDtoMapper
                .fromEntityListToResponseList(drinkRepository.findAll()
                        .stream()
                        .toList());
    }
    public List<DrinkEditResponseDto> getBeers(){
        return DrinkDtoMapper
                .fromEntityListToResponseList(drinkRepository.findAllBeers()
                        .stream()
                        .toList());
    }
    public DrinkEditResponseDto getDrink(Long id)
    {
        return DrinkDtoMapper
                .fromEntityToResponse(
                        drinkRepository
                                .findById(id)
                                .orElseThrow(()->new EntityIdNotFoundException(Drink.class,id))
                );
    }
    @Transactional
    public List<DrinkStyles> fetchDrinkStyles(DrinkEditRequestDto drinkRequest){
        List<DrinkStyles> drinkStylesEntityList = new ArrayList<>();
        if(drinkRequest.getDrinkStylesIDs()==null){
            log.info("empty drink styles list");
            return Collections.emptyList();
        }
        for( var id: drinkRequest.getDrinkStylesIDs()){
            drinkStylesEntityList.add(
                    drinkStylesRepository
                            .findById(id)
                            .orElseThrow(()->new EntityIdNotFoundException(DrinkStyles.class,id))
            );
        }
        return drinkStylesEntityList;
    }
    @Transactional
    public DrinkEditResponseDto addDrink(DrinkEditRequestDto drinkRequest)
    {
        List<DrinkStyles> drinkStyles = fetchDrinkStyles(drinkRequest);
        return DrinkDtoMapper.fromEntityToResponse(
                drinkRepository.save(
                        DrinkDtoMapper.fromRequestToEntity(drinkRequest, drinkStyles)
                )
        );
    }
    @Transactional
    public DrinkEditResponseDto editDrink(DrinkEditRequestDto drink)
    {
        if(drink==null || drink.getId()==null){
            throw new NullFieldException(Drink.class,"id");
        }
        Drink edited=drinkRepository
                .findById(drink.getId())
                .orElseThrow(()->new EntityIdNotFoundException(Drink.class,drink.getId()));

        List<DrinkStyles> drinkStyles = fetchDrinkStyles(drink);
        edited.setName(drink.getName());
        edited.setType(drink.getType());
        edited.setDrinkStyles(drinkStyles);
        edited.setBeer(BeerDtoMapper .fromRequestToEntity(drink.getBeer()));
        drinkRepository.save(edited);
        return DrinkDtoMapper.fromEntityToResponse(edited);
    }
    @Transactional
    public DrinkEditResponseDto patchDrink(DrinkEditRequestDto drinkRequest) {
        if(drinkRequest==null || drinkRequest.getId()==null){
            throw new NullFieldException(Drink.class,"id");
        }
        Drink patched = drinkRepository
                .findById(drinkRequest.getId())
                .orElseThrow(()->new EntityIdNotFoundException(Drink.class,drinkRequest.getId()));
        if(drinkRequest.getDrinkStylesIDs()!=null){
            patched.setDrinkStyles(fetchDrinkStyles(drinkRequest));
        }
        if (drinkRequest.getName() != null) {
            patched.setName(drinkRequest.getName());
        }
        if (drinkRequest.getType() != null) {
            patched.setType(drinkRequest.getType());
        }
        if(drinkRequest.getDrinkStylesIDs() != null){
            patched.setDrinkStyles(fetchDrinkStyles(drinkRequest));
        }
        if(drinkRequest.getBeer()!=null){
            patched.setBeer(BeerDtoMapper.fromRequestToEntity(drinkRequest.getBeer()));
        }
        drinkRepository.save(patched);
        return DrinkDtoMapper.fromEntityToResponse(patched);
    }
    public void deleteDrink(Long id)
    {
        drinkRepository.deleteById(id);
    }

}
