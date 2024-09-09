package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.dto.editdto.request.PhotoEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.PhotoEditResponseDto;
import com.sartyro.pubberrestapi.service.PhotoService;
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
public class PhotoController {
    private final PhotoService photoService;
    @GetMapping("pubs/-/photos/*")
    public List<PhotoEditResponseDto> getPhotos()
    {
        return photoService.getPhotos();
    }
    @GetMapping("pubs/-/photos/{id}")
    public PhotoEditResponseDto getPhotoById(@PathVariable @Positive Long id)
    {
        return photoService.getPhoto(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("pubs/{pubId}/photos")
    public PhotoEditResponseDto addPhoto(@PathVariable Long pubId, @RequestBody @Valid PhotoEditRequestDto photo)
    {
        photo.setId(EMPTY_ID);
        return photoService.addPhoto(photo,pubId);
    }
    @PutMapping("pubs/-/photos/{id}")
    public PhotoEditResponseDto editPhoto(@PathVariable @Positive Long id,@RequestBody @Valid PhotoEditRequestDto photo)
    {
        photo.setId(id);
        return photoService.editPhoto(photo);
    }

    @PatchMapping("pubs/-/photos/{id}")
    public PhotoEditResponseDto patchPhoto(@PathVariable @Positive Long id,@RequestBody PhotoEditRequestDto photo)
    {
        photo.setId(id);
        return photoService.editPhoto(photo);
    }
    @DeleteMapping("pubs/-/photos/{id}")
    public void deletePhoto(@PathVariable @Positive Long id)
    {
        photoService.deletePhoto(id);
    }
}
