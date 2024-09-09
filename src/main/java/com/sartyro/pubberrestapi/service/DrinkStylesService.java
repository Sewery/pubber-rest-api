package com.sartyro.pubberrestapi.service;

import com.sartyro.pubberrestapi.dto.editdto.mapppers.DrinkStylesDtoMapper;
import com.sartyro.pubberrestapi.dto.editdto.request.DrinkStylesEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.DrinkStylesEditResponseDto;
import com.sartyro.pubberrestapi.exception.EntityIdNotFoundException;
import com.sartyro.pubberrestapi.exception.NullFieldException;
import com.sartyro.pubberrestapi.model.DrinkStyles;
import com.sartyro.pubberrestapi.repository.DrinkStylesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkStylesService {
    private final DrinkStylesRepository drinkStylesRepository;

    public List<DrinkStylesEditResponseDto> getDrinkStyles() {
        return DrinkStylesDtoMapper.fromEntityListToResponseList(drinkStylesRepository.findAll());
    }

    public DrinkStylesEditResponseDto getDrinkStyle(Long id) {
        return DrinkStylesDtoMapper.fromEntityToResponse(
                drinkStylesRepository
                        .findById(id)
                        .orElseThrow(()->new EntityIdNotFoundException(DrinkStyles.class,id))
        );
    }

    public DrinkStylesEditResponseDto addDrinkStyle(DrinkStylesEditRequestDto drinkStyle) {
        return DrinkStylesDtoMapper.fromEntityToResponse(
                drinkStylesRepository
                        .save(DrinkStylesDtoMapper.fromRequestToEntity(drinkStyle))
        );
    }
    @Transactional
    public DrinkStylesEditResponseDto editDrinkStyle(DrinkStylesEditRequestDto drinkStyle) {
        if(drinkStyle==null || drinkStyle.getId()==null){
            throw new NullFieldException(DrinkStyles.class,"id");
        }
        DrinkStyles edited=drinkStylesRepository
                .findById(drinkStyle.getId())
                .orElseThrow(()->new EntityIdNotFoundException(DrinkStyles.class,drinkStyle.getId()));
        edited.setStyleName(drinkStyle.getStyleName());
        drinkStylesRepository.save(edited);
        return DrinkStylesDtoMapper.fromEntityToResponse(edited);
    }
    @Transactional
    public DrinkStylesEditResponseDto patchDrinkStyle(DrinkStylesEditRequestDto drinkStyle) {
        if(drinkStyle==null || drinkStyle.getId()==null){
            throw new NullFieldException(DrinkStyles.class,"id");
        }
        DrinkStyles patched = drinkStylesRepository
                .findById(drinkStyle.getId())
                .orElseThrow(()->new EntityIdNotFoundException(DrinkStyles.class,drinkStyle.getId()));
        if (drinkStyle.getStyleName() != null) {
            patched.setStyleName(drinkStyle.getStyleName());
        }
        drinkStylesRepository.save(patched);
        return DrinkStylesDtoMapper.fromEntityToResponse(patched);
    }

    public void deleteDrink(Long id) {
        drinkStylesRepository.deleteById(id);
    }
}
