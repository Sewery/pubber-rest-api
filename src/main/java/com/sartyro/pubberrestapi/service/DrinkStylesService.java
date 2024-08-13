package com.sartyro.pubberrestapi.service;

import com.sartyro.pubberrestapi.controller.editdto.DrinkEditDto;
import com.sartyro.pubberrestapi.controller.editdto.DrinkStylesEditDto;
import com.sartyro.pubberrestapi.controller.editdto.mappers.DrinkStylesEditDtoMapper;
import com.sartyro.pubberrestapi.exception.EntityIdNotFoundException;
import com.sartyro.pubberrestapi.exception.NullFieldException;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.DrinkStyles;
import com.sartyro.pubberrestapi.repository.DrinkStylesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkStylesService {
    private final DrinkStylesRepository drinkStylesRepository;

    public List<DrinkStylesEditDto> getDrinkStyles() {
        return drinkStylesRepository.findAll()
                .stream()
                .map(DrinkStylesEditDtoMapper::mapToDto)
                .toList();
    }

    public DrinkStylesEditDto getDrinkStyle(Long id) {
        return DrinkStylesEditDtoMapper.mapToDto(drinkStylesRepository.findById(id)
                .orElseThrow(()->new EntityIdNotFoundException(DrinkStyles.class,id)));
    }

    public DrinkStylesEditDto addDrinkStyle( DrinkStylesEditDto drinkStyle) {
//        drinkStyle.setId(DrinkEditDto.EMPTY_ID);
        return DrinkStylesEditDtoMapper.mapToDto(drinkStylesRepository.save(DrinkStylesEditDtoMapper.mapToEntity(drinkStyle)));
    }
    @Transactional
    public DrinkStylesEditDto editDrinkStyle( DrinkStylesEditDto drinkStyle) {
        if(drinkStyle==null || drinkStyle.getId()==null){
            throw new NullFieldException(DrinkStyles.class,"id");
        }
        DrinkStyles edited=drinkStylesRepository.findById(drinkStyle.getId())
                .orElseThrow(()->new EntityIdNotFoundException(DrinkStyles.class,drinkStyle.getId()));
        edited.setStyleName(drinkStyle.getStyleName());
        drinkStylesRepository.save(edited);
        return DrinkStylesEditDtoMapper.mapToDto(edited);
    }
    @Transactional
    public DrinkStylesEditDto patchDrinkStyle(DrinkStylesEditDto drinkStyle) {
        if(drinkStyle==null || drinkStyle.getId()==null){
            throw new NullFieldException(DrinkStyles.class,"id");
        }
        DrinkStyles patched = drinkStylesRepository.findById(drinkStyle.getId())
                .orElseThrow(()->new EntityIdNotFoundException(DrinkStyles.class,drinkStyle.getId()));
        if (drinkStyle.getStyleName() != null) {
            patched.setStyleName(drinkStyle.getStyleName());
        }
        drinkStylesRepository.save(patched);
        return DrinkStylesEditDtoMapper.mapToDto(patched);
    }

    public void deleteDrink(Long id) {
        drinkStylesRepository.deleteById(id);
    }
}
