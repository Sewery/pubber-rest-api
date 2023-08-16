package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.controller.editdto.PhotoEditDto;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.Photo;
import com.sartyro.pubberrestapi.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;
    @GetMapping("/photos/*")
    public List<PhotoEditDto> getPhotos()
    {
        return photoService.getPhotos();
    }
    @GetMapping("/photos/{id}")
    public PhotoEditDto getSinglePhoto(@PathVariable @Valid Long id)
    {
        return photoService.getPhoto(id);
    }
    @PostMapping("/photos")
    public PhotoEditDto addPhoto(@RequestBody @Valid PhotoEditDto photo)
    {
        return photoService.addPhoto(photo);
    }
    @PutMapping("/photos")
    public PhotoEditDto editPhoto(@RequestBody @Valid PhotoEditDto photo)
    {
        return photoService.editPhoto(photo);
    }
    @DeleteMapping("/photos")
    public void deletePhoto(@PathVariable Long id)
    {
        photoService.deletePhoto(id);
    }
}
