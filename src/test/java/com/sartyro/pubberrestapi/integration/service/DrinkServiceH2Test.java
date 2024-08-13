package com.sartyro.pubberrestapi.integration.service;

import com.sartyro.pubberrestapi.controller.editdto.DrinkEditDto;
import com.sartyro.pubberrestapi.controller.editdto.DrinkStylesEditDto;
import com.sartyro.pubberrestapi.service.DrinkService;
import com.sartyro.pubberrestapi.service.DrinkStylesService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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
        List<DrinkStylesEditDto> startDrinkStyles = List.of(
                DrinkStylesEditDto.builder()
                        .id(1L)
                        .styleName("IPA")
                        .build(),
                DrinkStylesEditDto.builder()
                        .id(2L)
                        .styleName("Pszeniczne")
                        .build(),
                DrinkStylesEditDto.builder()
                        .id(3L)
                        .styleName("APA")
                        .build()
        );
        List<DrinkEditDto> startDrinks = List.of(
            DrinkEditDto.builder()
                    .id(1L)
                    .name("Amber")
                    .type("Beer")
                    .drinkStyles(List.of(startDrinkStyles.get(0), startDrinkStyles.get(2)))
                    .build(),
            DrinkEditDto.builder()
                    .id(2L)
                    .name("Tyskie")
                    .type("Beer")
                    .drinkStyles(List.of(startDrinkStyles.get(1)))
                    .build(),
            DrinkEditDto.builder()
                    .id(3L)
                    .name("Harnaś")
                    .type("Beer")
                    .build()
        );

        //When
        drinkStylesService.addDrinkStyle(startDrinkStyles.get(0));
        drinkStylesService.addDrinkStyle(startDrinkStyles.get(1));
        List<DrinkStylesEditDto> resultDrinkStyles = drinkStylesService.getDrinkStyles();

        startDrinks.get(0).setDrinkStyles(resultDrinkStyles);
        startDrinks.get(1).setDrinkStyles(List.of(resultDrinkStyles.get(0)));
        startDrinks.get(2).setDrinkStyles(List.of());
        drinkService.addDrink( startDrinks.get(0));
        drinkService.addDrink( startDrinks.get(1));
        drinkService.addDrink(startDrinks.get(2));
        List<DrinkEditDto> resultDrinks = drinkService.getDrinks();

        //Then
        for(int i=0;i<resultDrinkStyles.size();i++){
            assertEquals(startDrinkStyles.get(i).getId(),
                    resultDrinkStyles.get(i).getId());
            assertEquals(startDrinkStyles.get(i).getStyleName(),
                    resultDrinkStyles.get(i).getStyleName());
        }
        for(int i=0;i<resultDrinks.size();i++){
            assertEquals(
                    startDrinks.get(i).getId(),
                    resultDrinks.get(i).getId());
            assertEquals(
                    startDrinks.get(i).getName(),
                    resultDrinks.get(i).getName());
            assertEquals(
                    startDrinks.get(i).getType(),
                    resultDrinks.get(i).getType());
            assertEquals(
                    startDrinks.get(i).getDescription(),
                    resultDrinks.get(i).getDescription()
            );
            assertEquals(
                    startDrinks.get(i).getDrinkStyles(),
                    resultDrinks.get(i).getDrinkStyles());
        }
    }
}