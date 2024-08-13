package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.controller.editdto.DrinkStylesEditDto;
import com.sartyro.pubberrestapi.service.DrinkStylesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class DrinkStylesController {

    private final DrinkStylesService drinkStylesService;
    @GetMapping("/drink_styles/*")
    public List<DrinkStylesEditDto> getDrinkStyles() {
        return drinkStylesService.getDrinkStyles();
    }
    @GetMapping("/drink_styles/{id}")
    public DrinkStylesEditDto getSingleDrinkStyle(@PathVariable @Positive Long id)
    {
       return drinkStylesService.getDrinkStyle(id);
    }
    @PostMapping("/drink_styles")
    public DrinkStylesEditDto addDrinkStyle(@RequestBody  @Valid DrinkStylesEditDto drink)
    {
        return drinkStylesService.addDrinkStyle(drink);
    }

    @PutMapping("/drink_styles")
    public DrinkStylesEditDto editDrinkStyle(@RequestBody  @Valid DrinkStylesEditDto drink)
    {
        return drinkStylesService.editDrinkStyle(drink);
    }
    @PatchMapping("/drink_styles")
    public DrinkStylesEditDto patchDrinkStyle(@RequestBody @Valid DrinkStylesEditDto drink)
    {
        return drinkStylesService.patchDrinkStyle(drink);
    }
    @DeleteMapping("/drink_styles/{id}")
    public void deleteDrinkStyle(@PathVariable @Positive Long id)
    {
        drinkStylesService.deleteDrink(id);
    }
}
