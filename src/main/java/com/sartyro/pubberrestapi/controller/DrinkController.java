package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.controller.editdto.DrinkEditDto;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.service.DrinkService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NaturalIdCache;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DrinkController {
    private final DrinkService drinkService;

    @GetMapping("/drinks/*")
    public List<DrinkEditDto> getDrinks() {
        return drinkService.getDrinks();
    }
    @GetMapping("/drinks/{id}")
    public DrinkEditDto getSingleDrink(@PathVariable Long id)
    {
        return drinkService.getDrink(id);
    }
    @PostMapping("/drinks")
    public DrinkEditDto addDrink(@RequestBody @Valid DrinkEditDto drink)
    {
        return drinkService.addDrink(drink);
    }

    @PutMapping("/drinks")
    public DrinkEditDto editDrink(@RequestBody @Valid DrinkEditDto drink)
    {
        return drinkService.editDrink(drink);
    }
    @PatchMapping("/drinks")
    public DrinkEditDto patchDrink(@RequestBody DrinkEditDto drink)
    {
        return drinkService.patchDrink(drink);
    }
    @DeleteMapping("/drinks/{id}")
    public void deleteDrink(@PathVariable Long id)
    {
         drinkService.deleteDrink(id);
    }

}
