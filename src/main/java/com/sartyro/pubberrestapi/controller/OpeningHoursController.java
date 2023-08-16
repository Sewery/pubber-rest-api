package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.controller.clientdto.OpeningHoursClientDto;
import com.sartyro.pubberrestapi.controller.editdto.OpeningHoursEditDto;
import com.sartyro.pubberrestapi.model.OpeningHours;
import com.sartyro.pubberrestapi.model.Photo;
import com.sartyro.pubberrestapi.model.Pub;
import com.sartyro.pubberrestapi.service.OpeningHoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OpeningHoursController {
    private final OpeningHoursService openingHoursService;

    @GetMapping("/openingHours/*")
    public List<OpeningHoursEditDto> getOpeningHours()
    {
        return openingHoursService.getAllOpeningHours();
    }
    @GetMapping("/openingHours/{id}")
    public OpeningHoursEditDto getSinglePhoto(@PathVariable Long id)
    {
        return openingHoursService.getOpeningHours(id);
    }
    @PostMapping("/openingHours")
    public OpeningHoursEditDto addPhoto(@RequestBody @Valid OpeningHoursEditDto openingHours)
    {
        return openingHoursService.addOpeningHours(openingHours);
    }
    @PutMapping("/openingHours")
    public OpeningHoursEditDto editPhoto(@RequestBody @Valid OpeningHoursEditDto openingHours)
    {
        return openingHoursService.editOpeningHours(openingHours);
    }
    @PatchMapping("/openingHours")
    public OpeningHoursEditDto patchPub(@RequestBody @Valid OpeningHoursEditDto openingHours)
    {
        return openingHoursService.patchOpeningHours(openingHours);
    }
    @DeleteMapping("/openingHours")
    public void deletePhoto(@PathVariable Long id)
    {
        openingHoursService.deleteOpeningHours(id);
    }
}
