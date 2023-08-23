package com.sartyro.pubberrestapi.service;

import com.sartyro.pubberrestapi.controller.editdto.DrinkEditDto;
import com.sartyro.pubberrestapi.controller.editdto.mappers.DrinkEditDtoMapper;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.OpeningHours;
import com.sartyro.pubberrestapi.repository.DrinkRepository;
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
        return  DrinkEditDtoMapper.mapToDto(drinkRepository.findById(id).orElseThrow());
    }
    public DrinkEditDto addDrink(DrinkEditDto drink)
    {
        drink.setId(DrinkEditDto.EMPTY_ID);
        return DrinkEditDtoMapper.mapToDto(drinkRepository.save(DrinkEditDtoMapper.mapToEntity(drink)));
    }
    @Transactional
    public DrinkEditDto editDrink(DrinkEditDto drink)
    {
        Drink edited=drinkRepository.findById(drink.getId()).orElseThrow();
        edited.setName(drink.getName());
        edited.setType(drink.getType());
        drinkRepository.save(edited);
        return DrinkEditDtoMapper.mapToDto(edited);
    }
    @Transactional
    public DrinkEditDto patchDrink(DrinkEditDto drink) {
        Drink patched = drinkRepository.findById(drink.getId()).orElseThrow();
        if (drink.getName() != null) {
            patched.setName(drink.getName());
        }
        if (drink.getType() != null) {
            patched.setType(drink.getType());
        }
        drinkRepository.save(patched);
        return DrinkEditDtoMapper.mapToDto(patched);
    }
    public void deleteDrink(Long id)
    {
        drinkRepository.deleteById(id);
    }

}
