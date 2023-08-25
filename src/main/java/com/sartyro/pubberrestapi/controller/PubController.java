package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.controller.clientdto.PubClientDto;
import com.sartyro.pubberrestapi.controller.editdto.PubEditDto;
import com.sartyro.pubberrestapi.service.PubService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequiredArgsConstructor
public class PubController {
    private final PubService pubService;

    @GetMapping("/pubs/*")
    public ResponseEntity<List<PubClientDto>> getPubs()
    {
        List<PubClientDto> pubs;
        try {
            pubs=pubService.getPubDtoListOptimized();
        }catch(Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>( pubs, HttpStatus.OK);
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
