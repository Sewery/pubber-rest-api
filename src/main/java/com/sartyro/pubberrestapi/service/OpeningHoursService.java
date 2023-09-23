package com.sartyro.pubberrestapi.service;

import com.sartyro.pubberrestapi.controller.clientdto.OpeningHoursClientDto;
import com.sartyro.pubberrestapi.controller.clientdto.mappers.OpeningHoursClientDtoMapper;
import com.sartyro.pubberrestapi.controller.editdto.OpeningHoursEditDto;
import com.sartyro.pubberrestapi.controller.editdto.mappers.OpeningHoursEditDtoMapper;
import com.sartyro.pubberrestapi.model.OpeningHours;
import com.sartyro.pubberrestapi.model.Pub;
import com.sartyro.pubberrestapi.repository.OpeningHoursRepository;
import com.sartyro.pubberrestapi.repository.PubRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OpeningHoursService {
    private final OpeningHoursRepository openingHoursRepository;
    private final PubRepository pubRepository;

    public List<OpeningHoursEditDto> getAllOpeningHours() {
        return OpeningHoursEditDtoMapper
                .mapToDtoList(StreamSupport
                        .stream(openingHoursRepository.findAll()
                                .spliterator(),false)
                        .toList());
    }

    public OpeningHoursEditDto getOpeningHours(Long id) {
        return OpeningHoursEditDtoMapper
                .mapToDto(openingHoursRepository.findById(id).orElseThrow());
    }

    public OpeningHoursEditDto addOpeningHours(OpeningHoursEditDto openingHours , Long pubId) {
        Pub pub= pubRepository.findById(pubId).orElseThrow();
        return OpeningHoursEditDtoMapper
                .mapToDto(openingHoursRepository.save(OpeningHoursEditDtoMapper.mapToEntity(openingHours,pub)));
    }



    @Transactional
    public OpeningHoursEditDto  editOpeningHours(OpeningHoursEditDto openingHours) {
        OpeningHours edited = openingHoursRepository.findById(openingHours.getId()).orElseThrow();
        edited.setTimeOpen(openingHours.getTimeOpen());
        edited.setTimeClose(openingHours.getTimeClose());
        edited.setWeekday(openingHours.getWeekday());
        openingHoursRepository.save(edited);
        return OpeningHoursEditDtoMapper.mapToDto(edited);
    }
    @Transactional
    public OpeningHoursEditDto patchOpeningHours(OpeningHoursEditDto openingHours) {
        OpeningHours patched = openingHoursRepository.findById(openingHours.getId()).orElseThrow();
        patched.setTimeOpen(openingHours.getTimeOpen());
        patched.setTimeClose(openingHours.getTimeClose());
        if (openingHours.getWeekday() != null) {
            patched.setWeekday(openingHours.getWeekday());
        }
        openingHoursRepository.save(patched);
        return OpeningHoursEditDtoMapper.mapToDto(patched);
    }
    public void deleteOpeningHours(Long id) {
        openingHoursRepository.deleteById(id);
    }


}
