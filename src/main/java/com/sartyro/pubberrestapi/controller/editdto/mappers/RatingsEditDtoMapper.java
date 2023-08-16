package com.sartyro.pubberrestapi.controller.editdto.mappers;

import com.sartyro.pubberrestapi.controller.editdto.RatingsEditDto;
import com.sartyro.pubberrestapi.model.Ratings;

public class RatingsEditDtoMapper {
    public static RatingsEditDto mapToDto(Ratings ratings)
    {
        return RatingsEditDto.builder()
                .id(ratings.getId())
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
    public static Ratings mapToEntity(RatingsEditDto ratings)
    {
        return null;
    }
}
