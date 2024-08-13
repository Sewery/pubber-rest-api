package com.sartyro.pubberrestapi.service;

import com.sartyro.pubberrestapi.controller.editdto.DrinkEditDto;
import com.sartyro.pubberrestapi.controller.editdto.mappers.DrinkEditDtoMapper;
import com.sartyro.pubberrestapi.controller.editdto.mappers.DrinkStylesEditDtoMapper;
import com.sartyro.pubberrestapi.exception.EntityIdNotFoundException;
import com.sartyro.pubberrestapi.exception.NullFieldException;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.repository.DrinkRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class DrinkService {
    private final DrinkRepository drinkRepository;

    public List<DrinkEditDto> getDrinks()
    {
        return DrinkEditDtoMapper
                .mapToDtoList(StreamSupport
                        .stream(drinkRepository.findAll()
                                .spliterator(),false)
                        .toList());
    }
    public DrinkEditDto getDrink(Long id)
    {
        return DrinkEditDtoMapper.mapToDto(drinkRepository.findById(id)
                .orElseThrow(()->new EntityIdNotFoundException(Drink.class,id)));
    }
    public DrinkEditDto addDrink(DrinkEditDto drink)
    {
//        drink.setId(DrinkEditDto.EMPTY_ID);
        return DrinkEditDtoMapper.mapToDto(drinkRepository.save(DrinkEditDtoMapper.mapToEntity(drink)));
    }
    @Transactional
    public DrinkEditDto editDrink(DrinkEditDto drink)
    {
        if(drink==null || drink.getId()==null){
            throw new NullFieldException(Drink.class,"id");
        }
        Drink edited=drinkRepository.findById(drink.getId())
                .orElseThrow(()->new EntityIdNotFoundException(Drink.class,drink.getId()));
        edited.setName(drink.getName());
        edited.setType(drink.getType());
        edited.setDrinkStyles(DrinkStylesEditDtoMapper.mapToEntityList(drink.getDrinkStyles()));
        drinkRepository.save(edited);
        return DrinkEditDtoMapper.mapToDto(edited);
    }
    @Transactional
    public DrinkEditDto patchDrink(DrinkEditDto drink) {
        if(drink==null || drink.getId()==null){
            throw new NullFieldException(Drink.class,"id");
        }
        Drink patched = drinkRepository.findById(drink.getId())
                .orElseThrow(()->new EntityIdNotFoundException(Drink.class,drink.getId()));
        if (drink.getName() != null) {
            patched.setName(drink.getName());
        }
        if (drink.getType() != null) {
            patched.setType(drink.getType());
        }
        if(drink.getDrinkStyles() != null){
            patched.setDrinkStyles(DrinkStylesEditDtoMapper.mapToEntityList(drink.getDrinkStyles()));
        }
        drinkRepository.save(patched);
        return DrinkEditDtoMapper.mapToDto(patched);
    }
    public void deleteDrink(Long id)
    {
        drinkRepository.deleteById(id);
    }

}
