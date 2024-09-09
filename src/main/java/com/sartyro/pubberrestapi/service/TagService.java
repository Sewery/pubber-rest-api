package com.sartyro.pubberrestapi.service;


import com.sartyro.pubberrestapi.dto.editdto.mapppers.TagDtoMapper;
import com.sartyro.pubberrestapi.dto.editdto.request.TagEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.TagEditResponseDto;
import com.sartyro.pubberrestapi.exception.EntityIdNotFoundException;
import com.sartyro.pubberrestapi.exception.NullFieldException;
import com.sartyro.pubberrestapi.model.Pub;
import com.sartyro.pubberrestapi.model.Tag;
import com.sartyro.pubberrestapi.repository.PubRepository;
import com.sartyro.pubberrestapi.repository.TagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final PubRepository pubRepository;
    public List<TagEditResponseDto> getTags()
    {
        return TagDtoMapper.fromEntityListToResponseList(StreamSupport
                .stream(tagRepository.findAll().spliterator(),false)
                .toList());
    }
    public TagEditResponseDto getTagById(Long id)
    {
        return TagDtoMapper.fromEntityToResponse(tagRepository
                .findById(id)
                .orElseThrow(()->new EntityIdNotFoundException(Tag.class,id)));
    }
    public TagEditResponseDto addTag(TagEditRequestDto tag, Long pubId)
    {
        Pub pub= pubRepository
                .findById(pubId)
                .orElseThrow(()->new EntityIdNotFoundException(Pub.class,pubId));
        return TagDtoMapper.fromEntityToResponse(tagRepository.save(TagDtoMapper.fromRequestToEntity(tag,pub)));
    }
    @Transactional
    public TagEditResponseDto editTag(TagEditRequestDto tag)
    {
        if(tag==null || tag.getId()==null){
            throw new NullFieldException(Tag.class,"id");
        }
        Tag edited=tagRepository
                .findById(tag.getId())
                .orElseThrow(()->new EntityIdNotFoundException(Tag.class,tag.getId()));
        edited.setId(tag.getId());
        edited.setName(tag.getName());
        tagRepository.save(edited);
        return TagDtoMapper.fromEntityToResponse(edited);
    }
    public void deleteTag(Long id)
    {
        tagRepository.deleteById(id);
    }
}
