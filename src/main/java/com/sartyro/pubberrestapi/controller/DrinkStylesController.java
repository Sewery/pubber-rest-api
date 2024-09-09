package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.dto.editdto.request.DrinkStylesEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.DrinkStylesEditResponseDto;
import com.sartyro.pubberrestapi.service.DrinkStylesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sartyro.pubberrestapi.util.Constants.EMPTY_ID;

@RestController
@RequiredArgsConstructor
@Validated
public class DrinkStylesController {

    private final DrinkStylesService drinkStylesService;
    @GetMapping("/drink_styles/*")
    public List<DrinkStylesEditResponseDto> getDrinkStyles() {
        return drinkStylesService.getDrinkStyles();
    }
    @GetMapping("/drink_styles/{id}")
    public DrinkStylesEditResponseDto getDrinkStyleById(@PathVariable @Positive Long id)
    {
       return drinkStylesService.getDrinkStyle(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/drink_styles")
    public DrinkStylesEditResponseDto addDrinkStyle(@RequestBody  @Valid DrinkStylesEditRequestDto drinkStyle)
    {
        drinkStyle.setId(EMPTY_ID);
        return drinkStylesService.addDrinkStyle(drinkStyle);
    }

    @PutMapping("/drink_styles/{id}")
    public DrinkStylesEditResponseDto editDrinkStyle(
            @PathVariable @Positive Long id,
            @RequestBody  @Valid DrinkStylesEditRequestDto drinkStyle
    ) {
        drinkStyle.setId(id);
        return drinkStylesService.editDrinkStyle(drinkStyle);
    }
    @PatchMapping("/drink_style/{id}")
    public DrinkStylesEditResponseDto patchDrinkStyle(
            @PathVariable @Positive Long id,
            @RequestBody @Valid DrinkStylesEditRequestDto drinkStyle
    ) {
        drinkStyle.setId(id);
        return drinkStylesService.patchDrinkStyle(drinkStyle);
    }
    @DeleteMapping("/drink_styles/{id}")
    public void deleteDrinkStyle(@PathVariable @Positive Long id)
    {
        drinkStylesService.deleteDrink(id);
    }
}
