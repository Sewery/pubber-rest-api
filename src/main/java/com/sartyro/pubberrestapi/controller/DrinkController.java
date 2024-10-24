package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.dto.editdto.request.DrinkEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.DrinkEditResponseDto;
import com.sartyro.pubberrestapi.service.DrinkService;
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
public class DrinkController {
    private final DrinkService drinkService;

    @GetMapping("/drinks/*")
    public List<DrinkEditResponseDto> getDrinks() {
        return drinkService.getDrinks();
    }
    @GetMapping("/drinks/beer/*")
    public List<DrinkEditResponseDto> getBeers() {
        return drinkService.getBeers();
    }
    @GetMapping("/drinks/{id}")
    public DrinkEditResponseDto getDrinkById(@PathVariable @Positive Long id)
    {
        return drinkService.getDrink(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/drinks")
    public DrinkEditResponseDto addDrink(@RequestBody @Valid DrinkEditRequestDto drink)
    {
        drink.setId(EMPTY_ID);
        return drinkService.addDrink(drink);
    }

    @PutMapping("/drinks/{id}")
    public DrinkEditResponseDto editDrink(@PathVariable @Positive Long id,@RequestBody @Valid DrinkEditRequestDto drink)
    {
        drink.setId(id);
        return drinkService.editDrink(drink);
    }
    @PatchMapping("/drinks/{id}")
    public DrinkEditResponseDto patchDrink(@PathVariable @Positive Long id,@RequestBody DrinkEditRequestDto drink)
    {
        drink.setId(id);
        return drinkService.patchDrink(drink);
    }
    @DeleteMapping("/drinks/{id}")
    public void deleteDrink(@PathVariable @Positive Long id)
    {
         drinkService.deleteDrink(id);
    }

}
