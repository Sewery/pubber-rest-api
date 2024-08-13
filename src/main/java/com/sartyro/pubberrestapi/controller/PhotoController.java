package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.controller.editdto.PhotoEditDto;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.Photo;
import com.sartyro.pubberrestapi.service.PhotoService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
@RestController
@RequiredArgsConstructor
@Validated
public class PhotoController {
    private final PhotoService photoService;
    @GetMapping("pubs/-/photos/*")
    public List<PhotoEditDto> getPhotos()
    {
        return photoService.getPhotos();
    }
    @GetMapping("pubs/-/photos/{id}")
    public PhotoEditDto getSinglePhoto(@PathVariable @Positive Long id)
    {
        return photoService.getPhoto(id);
    }
    @PostMapping("pubs/{pubId}/photos")
    public PhotoEditDto addPhoto(@PathVariable Long pubId,@RequestBody @Valid PhotoEditDto photo)
    {
        return photoService.addPhoto(photo,pubId);
    }
    @PutMapping("pubs/-/photos")
    public PhotoEditDto editPhoto(@RequestBody @Valid PhotoEditDto photo)
    {
        return photoService.editPhoto(photo);
    }

    @PatchMapping("pubs/-/photos")
    public PhotoEditDto patchPhoto(@RequestBody PhotoEditDto photo)
    {
        return photoService.editPhoto(photo);
    }
    @DeleteMapping("pubs/-/photos/{id}")
    public void deletePhoto(@PathVariable @Positive Long id)
    {
        photoService.deletePhoto(id);
    }
}
