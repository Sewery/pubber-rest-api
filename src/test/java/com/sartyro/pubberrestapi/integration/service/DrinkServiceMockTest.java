package com.sartyro.pubberrestapi.integration.service;

import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.DrinkStyles;
import com.sartyro.pubberrestapi.repository.DrinkRepository;
import com.sartyro.pubberrestapi.repository.DrinkStylesRepository;
import com.sartyro.pubberrestapi.service.DrinkService;
import com.sartyro.pubberrestapi.service.DrinkStylesService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class DrinkServiceMockTest {
    @Mock
    private DrinkRepository drinkRepository;
    @Mock
    private DrinkStylesRepository drinkStylesRepository;
    @InjectMocks
    private DrinkService drinkService;
    @InjectMocks
    private DrinkStylesService drinkStylesService;
    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
              /*  List<DrinkStyles> startDrinkStyles = List.of(
                new DrinkStyles(1L,"IPA",null),
                new DrinkStyles(2L,"Pszeniczne",null),
                new DrinkStyles(3L,"APA",null)
        );
        List<Drink> startDrinks = List.of(
                new Drink(1L,"Amber","Beer","A crisp and refreshing lag",null,List.of(startDrinkStyles.get(0), startDrinkStyles.get(2))),
                new Drink(2L,"Tyskie","Beer","A crisp and refreshing lag",null,List.of(startDrinkStyles.get(1))),
                new Drink(3L,"Harnaś","Beer","A crisp and refreshing lag",null,null));
        drinkStylesRepository.save(startDrinkStyles.get(0));
        drinkStylesRepository.save(startDrinkStyles.get(1));
        drinkStylesRepository.save(startDrinkStyles.get(2));
        startDrinks.get(0).setDrinkStyles(startDrinkStyles);
        startDrinks.get(1).setDrinkStyles(List.of(startDrinkStyles.get(0)));
        startDrinks.get(2).setDrinkStyles(List.of());
        drinkRepository.save(startDrinks.get(0));
        drinkRepository.save(startDrinks.get(1));
        drinkRepository.save(startDrinks.get(2));*/
        closeable = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }
    @Test
    void getAllDrinks() {
        //when
        drinkService.getDrinks();
        //then
        verify(drinkRepository).findAll();
    }
}
