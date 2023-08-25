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

    @GetMapping("pubs/-/openingHours/*")
    public List<OpeningHoursEditDto> getOpeningHours()
    {
        return openingHoursService.getAllOpeningHours();
    }
    @GetMapping("pubs/-/openingHours/{id}")
    public OpeningHoursEditDto getSingleOpeningHours(@PathVariable Long id)
    {
        return openingHoursService.getOpeningHours(id);
    }
    @PostMapping("pubs/{pubId}/openingHours")
    public OpeningHoursEditDto addOpeningHours(@PathVariable Long pubId,@RequestBody @Valid OpeningHoursEditDto openingHours)
    {
        return openingHoursService.addOpeningHours(openingHours,pubId);
    }
    @PutMapping("pubs/-/openingHours")
    public OpeningHoursEditDto editOpeningHours(@RequestBody @Valid OpeningHoursEditDto openingHours)
    {
        return openingHoursService.editOpeningHours(openingHours);
    }
    @PatchMapping("pubs/-/openingHours")
    public OpeningHoursEditDto patchOpeningHours(@RequestBody OpeningHoursEditDto openingHours)
    {
        return openingHoursService.patchOpeningHours(openingHours);
    }
    @DeleteMapping("pubs/-/openingHours/{id}")
    public void deleteOpeningHours(@PathVariable Long id)
    {
        openingHoursService.deleteOpeningHours(id);
    }
}
