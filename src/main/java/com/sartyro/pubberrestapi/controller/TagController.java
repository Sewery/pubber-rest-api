package com.sartyro.pubberrestapi.controller;

import com.sartyro.pubberrestapi.dto.editdto.request.TagEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.TagEditResponseDto;
import com.sartyro.pubberrestapi.service.TagService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class TagController {
    private final TagService tagService;
    @GetMapping("pubs/-/tags/*")
    public List<TagEditResponseDto> getTags()
    {
        return tagService.getTags();
    }
    @GetMapping("pubs/-/tags/{id}")
    public TagEditResponseDto getTagById(@PathVariable @Positive Long id)
    {
        return tagService.getTagById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("pubs/{pubId}/tags")
    public TagEditResponseDto addTag(@PathVariable Long pubId, @RequestBody @Valid TagEditRequestDto tag)
    {
        return tagService.addTag(tag,pubId);
    }
    @PutMapping("pubs/-/tags/{id}")
    public TagEditResponseDto editTag(@PathVariable @Positive Long id,@RequestBody @Valid TagEditRequestDto tag)
    {
        tag.setId(id);
        return tagService.editTag(tag);
    }

    @PatchMapping("pubs/-/tags/{id}")
    public TagEditResponseDto patchTag(@PathVariable @Positive Long id,@RequestBody TagEditRequestDto tag)
    {
        tag.setId(id);
        return tagService.editTag(tag);
    }
    @DeleteMapping("pubs/-/tags/{id}")
    public void deleteTag(@PathVariable @Positive Long id)
    {
        tagService.deleteTag(id);
    }
}
