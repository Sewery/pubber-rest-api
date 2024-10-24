package com.sartyro.pubberrestapi.dto.editdto.mapppers;

import com.sartyro.pubberrestapi.dto.editdto.request.BeerEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.BeerEditResponseDto;
import com.sartyro.pubberrestapi.model.Beer;
import com.sartyro.pubberrestapi.util.Constants;

public class BeerDtoMapper {
    private BeerDtoMapper() {throw new IllegalStateException("Utility class, calling constructor forbidden");}

    public static Beer fromRequestToEntity(BeerEditRequestDto beer)
    {
        if(beer == null)
            return null;
        return new Beer(
                Constants.EMPTY_ID,
                beer.getLongDescription(),
                beer.getShortDescription(),
                beer.getPhotoUrl(),
                beer.getMaltiness(),
                beer.getBlg(),
                beer.getAlcoholContent()
        );
    }
    public static BeerEditResponseDto fromEntityToResponse(Beer beer){
        if(beer == null)
            return null;
        return new BeerEditResponseDto(
                beer.getId(),
                beer.getLongDescription(),
                beer.getShortDescription(),
                beer.getPhotoUrl(),
                beer.getMaltiness(),
                beer.getBlg(),
                beer.getAlcoholContent()
        );
    }

}
