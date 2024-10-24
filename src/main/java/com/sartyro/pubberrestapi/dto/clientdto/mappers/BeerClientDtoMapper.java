package com.sartyro.pubberrestapi.dto.clientdto.mappers;

import com.sartyro.pubberrestapi.dto.clientdto.BeerClientDto;
import com.sartyro.pubberrestapi.model.Beer;

public class BeerClientDtoMapper {
    private BeerClientDtoMapper() {throw new IllegalStateException("Utility class, calling constructor forbidden");}

    public static BeerClientDto mapToDto(Beer beer)
    {
        if(beer == null)
            return null;
        return new BeerClientDto(
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
