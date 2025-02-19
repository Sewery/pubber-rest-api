package com.sartyro.pubberrestapi.integration.service;

import com.sartyro.pubberrestapi.dto.editdto.request.DrinkEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.request.DrinkStylesEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.DrinkEditResponseDto;
import com.sartyro.pubberrestapi.dto.editdto.response.DrinkStylesEditResponseDto;
import com.sartyro.pubberrestapi.service.DrinkService;
import com.sartyro.pubberrestapi.service.DrinkStylesService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DrinkServiceH2Test {
    private static final Logger log = LoggerFactory.getLogger(DrinkServiceH2Test.class);
    @Autowired
    private DrinkService drinkService;
    @Autowired
    private DrinkStylesService drinkStylesService;
    @Test
    void itShouldGetAllDrinksWithStylesName() {
        //Given
        List<DrinkStylesEditRequestDto> startDrinkStyles = List.of(
                DrinkStylesEditRequestDto.builder()
                        .id(1L)
                        .styleName("IPA")
                        .build(),
                DrinkStylesEditRequestDto.builder()
                        .id(2L)
                        .styleName("Pszeniczne")
                        .build(),
                DrinkStylesEditRequestDto.builder()
                        .id(3L)
                        .styleName("APA")
                        .build()
        );
        List<DrinkEditRequestDto> startDrinks = List.of(
            DrinkEditRequestDto.builder()
                    .id(1L)
                    .name("Amber")
                    .type("Beer")
                    .drinkStylesIDs(List.of(startDrinkStyles.get(0).getId(), startDrinkStyles.get(2).getId()))
                    .build(),
            DrinkEditRequestDto.builder()
                    .id(2L)
                    .name("Tyskie")
                    .type("Beer")
                    .drinkStylesIDs(List.of(startDrinkStyles.get(1).getId()))
                    .build(),
            DrinkEditRequestDto.builder()
                    .id(3L)
                    .name("Harnaś")
                    .type("Beer")
                    .build()
        );

        //When
        drinkStylesService.addDrinkStyle(startDrinkStyles.get(0));
        drinkStylesService.addDrinkStyle(startDrinkStyles.get(1));
        List<DrinkStylesEditResponseDto> resultDrinkStyles = drinkStylesService.getDrinkStyles();

        startDrinks.get(0).setDrinkStylesIDs(resultDrinkStyles.stream().map(DrinkStylesEditResponseDto::id).collect(Collectors.toList()));
        startDrinks.get(1).setDrinkStylesIDs(List.of(resultDrinkStyles.get(0).id()));
        startDrinks.get(2).setDrinkStylesIDs(List.of());
        drinkService.addDrink( startDrinks.get(0));
        drinkService.addDrink( startDrinks.get(1));
        drinkService.addDrink(startDrinks.get(2));
        List<DrinkEditResponseDto> resultDrinks = drinkService.getDrinks();

        //Then
        for(int i=0;i<resultDrinkStyles.size();i++){
            assertEquals(startDrinkStyles.get(i).getId(),
                    resultDrinkStyles.get(i).id());
            assertEquals(startDrinkStyles.get(i).getStyleName(),
                    resultDrinkStyles.get(i).styleName());
        }
        for(int i=0;i<resultDrinks.size();i++){
            assertEquals(
                    startDrinks.get(i).getId(),
                    resultDrinks.get(i).id());
            assertEquals(
                    startDrinks.get(i).getName(),
                    resultDrinks.get(i).name());
            assertEquals(
                    startDrinks.get(i).getType(),
                    resultDrinks.get(i).type());
            assertEquals(
                    startDrinks.get(i).getDescription(),
                    resultDrinks.get(i).description()
            );
            assertEquals(
                    startDrinks.get(i).getDrinkStylesIDs(),
                    resultDrinks.get(i).drinkStyles().stream().map(DrinkStylesEditResponseDto::id).toList());
        }
    }
}