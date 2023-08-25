package com.sartyro.pubberrestapi.controller.clientdto.mappers;

import com.sartyro.pubberrestapi.controller.clientdto.RatingsClientDto;
import com.sartyro.pubberrestapi.model.Ratings;

public class RatingsClientDtoMapper {
    public static RatingsClientDto mapToDto(Ratings ratings)
    {
        return null==ratings?null:RatingsClientDto.builder()
                .google(ratings.getGoogle())
                .googleCount(ratings.getGoogleCount())
                .facebook(ratings.getFacebook())
                .facebookCount(ratings.getFacebookCount())
                .untapped(ratings.getUntapped())
                .untappedCount(ratings.getUntappedCount())
                .tripAdvisor(ratings.getTripAdvisor())
                .tripAdvisorCount(ratings.getTripAdvisorCount())
                .ourDrinksQuality(ratings.getOurDrinkQuality())
                .ourServiceQuality(ratings.getOurServiceQuality())
                .ourCost(ratings.getOurCost())
                .build();
    }
}
