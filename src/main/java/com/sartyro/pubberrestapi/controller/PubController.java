package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.dto.clientdto.PubClientDto;
import com.sartyro.pubberrestapi.dto.editdto.request.PubEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.PubEditResponseDto;
import com.sartyro.pubberrestapi.service.PubService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sartyro.pubberrestapi.util.Constants.EMPTY_ID;


@RestController
@RequiredArgsConstructor
@Slf4j
public class PubController {
    private final PubService pubService;
    @GetMapping("/pubs/*")
    public List<PubClientDto> getPubs()
    {
        return pubService.getPubDtoListOptimized();
    }
    @GetMapping("/pubs/{id}")
    public PubEditResponseDto getPubById(@PathVariable Long id)
    {
        return pubService.getPubById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/pubs")
    public PubEditResponseDto addPub(@RequestBody @Valid PubEditRequestDto pub)
    {
        pub.setId(EMPTY_ID);
        return pubService.addPub(pub);
    }
    @PutMapping("/pubs/{id}")
    public PubEditResponseDto editPub(@PathVariable @Positive Long id,@RequestBody @Valid PubEditRequestDto pub)
    {
        pub.setId(id);
        return pubService.editPub(pub);
    }
    @PatchMapping("/pubs/{id}")
    public PubEditResponseDto patchPub(@PathVariable @Positive Long id, @RequestBody PubEditRequestDto pub)
    {
        pub.setId(id);
        return pubService.patchPub(pub);
    }
    @DeleteMapping("/pubs/{id}")
    public void deletePub(@PathVariable Long id)
    {
          pubService.deletePub(id);
    }



}
