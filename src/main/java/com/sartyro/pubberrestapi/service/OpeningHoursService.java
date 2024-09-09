package com.sartyro.pubberrestapi.service;

import com.sartyro.pubberrestapi.dto.editdto.mapppers.OpeningHoursDtoMapper;
import com.sartyro.pubberrestapi.dto.editdto.request.OpeningHoursEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.OpeningHoursEditResponseDto;
import com.sartyro.pubberrestapi.exception.EntityIdNotFoundException;
import com.sartyro.pubberrestapi.exception.NullFieldException;
import com.sartyro.pubberrestapi.model.OpeningHours;
import com.sartyro.pubberrestapi.model.Pub;
import com.sartyro.pubberrestapi.repository.OpeningHoursRepository;
import com.sartyro.pubberrestapi.repository.PubRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OpeningHoursService {
    private final OpeningHoursRepository openingHoursRepository;
    private final PubRepository pubRepository;

    public List<OpeningHoursEditResponseDto> getAllOpeningHours() {
        return OpeningHoursDtoMapper
                .fromEntityListToResponseList(StreamSupport
                        .stream(openingHoursRepository.findAll()
                                .spliterator(),false)
                        .toList());
    }

    public OpeningHoursEditResponseDto getOpeningHours(Long id) {
        return OpeningHoursDtoMapper
                .fromEntityToResponse(
                        openingHoursRepository.findById(id)
                        .orElseThrow(()->new EntityIdNotFoundException(OpeningHours.class,id))
                );
    }

    public List<OpeningHoursEditResponseDto> getOpeningHoursByPub(@Positive Long id) {
        return OpeningHoursDtoMapper
                .fromEntityListToResponseList(openingHoursRepository.findByIdPub(id));
    }

    public OpeningHoursEditResponseDto addOpeningHours(OpeningHoursEditRequestDto openingHours , Long pubId) {
        Pub pub= pubRepository.findById(pubId)
                .orElseThrow(()->new EntityIdNotFoundException(Pub.class,pubId));
        return OpeningHoursDtoMapper
                .fromEntityToResponse(
                        openingHoursRepository.save(OpeningHoursDtoMapper.fromRequestToEntity(openingHours,pub))
                );
    }



    @Transactional
    public OpeningHoursEditResponseDto editOpeningHours(OpeningHoursEditRequestDto openingHours) {
        if(openingHours==null || openingHours.getId()==null){
            throw new NullFieldException(OpeningHours.class,"id");
        }
        OpeningHours edited = openingHoursRepository
                .findById(openingHours.getId())
                .orElseThrow(()->new EntityIdNotFoundException(OpeningHours.class,openingHours.getId()));
        edited.setTimeOpen(openingHours.getTimeOpen());
        edited.setTimeClose(openingHours.getTimeClose());
        edited.setWeekday(openingHours.getWeekday());
        openingHoursRepository.save(edited);
        return OpeningHoursDtoMapper.fromEntityToResponse(edited);
    }
    @Transactional
    public OpeningHoursEditResponseDto patchOpeningHours(OpeningHoursEditRequestDto openingHours) {
        if(openingHours==null || openingHours.getId()==null){
            throw new NullFieldException(OpeningHours.class,"id");
        }
        OpeningHours patched = openingHoursRepository
                .findById(openingHours.getId())
                .orElseThrow(()->new EntityIdNotFoundException(OpeningHours.class,openingHours.getId()));
        if (openingHours.getTimeOpen() != null) {
            patched.setTimeOpen(openingHours.getTimeOpen());
        }
        if (openingHours.getTimeClose() != null) {
            patched.setTimeClose(openingHours.getTimeClose());
        }
        if (openingHours.getWeekday() != null) {
            patched.setWeekday(openingHours.getWeekday());
        }
        openingHoursRepository.save(patched);
        return OpeningHoursDtoMapper.fromEntityToResponse(patched);
    }
    public void deleteOpeningHours(Long id) {
        openingHoursRepository.deleteById(id);
    }


}
