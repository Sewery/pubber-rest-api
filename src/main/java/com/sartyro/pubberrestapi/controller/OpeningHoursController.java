package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.dto.editdto.request.OpeningHoursEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.OpeningHoursEditResponseDto;
import com.sartyro.pubberrestapi.service.OpeningHoursService;
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
public class OpeningHoursController {
    private final OpeningHoursService openingHoursService;

    @GetMapping("pubs/-/openingHours/*")
    public List<OpeningHoursEditResponseDto> getOpeningHours()
    {
        return openingHoursService.getAllOpeningHours();
    }
    @GetMapping("pubs/-/openingHours/{id}")
    public OpeningHoursEditResponseDto getOpeningHoursById(@PathVariable @Positive Long id)
    {
        return openingHoursService.getOpeningHours(id);
    }
    @GetMapping("pubs/{pubId}/openingHours")
    public List<OpeningHoursEditResponseDto> getOpeningHoursByPubId(@PathVariable @Positive Long pubId)
    {
        return openingHoursService.getOpeningHoursByPub(pubId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("pubs/{pubId}/openingHours")
    public OpeningHoursEditResponseDto addOpeningHours(
            @PathVariable @Positive Long pubId,
            @RequestBody @Valid OpeningHoursEditRequestDto openingHours
    ) {
        openingHours.setId(EMPTY_ID);
        return openingHoursService.addOpeningHours(openingHours,pubId);
    }
    @PutMapping("pubs/-/openingHours/{id}")
    public OpeningHoursEditResponseDto editOpeningHours(
            @PathVariable @Positive Long id,
            @RequestBody @Valid OpeningHoursEditRequestDto openingHours
    ) {
        openingHours.setId(id);
        return openingHoursService.editOpeningHours(openingHours);
    }
    @PatchMapping("pubs/-/openingHours/{id}")
    public OpeningHoursEditResponseDto patchOpeningHours(
            @PathVariable @Positive Long id,
            @RequestBody OpeningHoursEditRequestDto openingHours
    ) {
        openingHours.setId(id);
        return openingHoursService.patchOpeningHours(openingHours);
    }
    @DeleteMapping("pubs/-/openingHours/{id}")
    public void deleteOpeningHours(@PathVariable @Positive Long id)
    {
        openingHoursService.deleteOpeningHours(id);
    }
}
