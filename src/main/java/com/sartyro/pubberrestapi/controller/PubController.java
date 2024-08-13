package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.controller.clientdto.PubClientDto;
import com.sartyro.pubberrestapi.controller.editdto.PubEditDto;
import com.sartyro.pubberrestapi.service.PubService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.logging.Logger;


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
    public PubEditDto getSinglePub(@PathVariable Long id)
    {
        return pubService.getSinglePub(id);
    }
    @PostMapping("/pubs")
    public PubEditDto addPub(@RequestBody @Valid PubEditDto pub)
    {
        return pubService.addPub(pub);
    }
    @PutMapping("/pubs")
    public PubEditDto editPub(@RequestBody @Valid PubEditDto pub)
    {
        return pubService.editPub(pub);
    }
    @PatchMapping("/pubs")
    public PubEditDto patchPub(@RequestBody PubEditDto pub)
    {
        return pubService.patchPub(pub);
    }
    @DeleteMapping("/pubs/{id}")
    public void deletePub(@PathVariable Long id)
    {
          pubService.deletePub(id);
    }



}
