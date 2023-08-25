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
        return ratings==null?null:new Ratings(ratings.getId(), ratings.getGoogle(), ratings.getGoogleCount(),
                ratings.getFacebook(), ratings.getFacebookCount(),
                ratings.getTripAdvisor(), ratings.getTripAdvisorCount(),
                ratings.getUntapped(), ratings.getUntappedCount(),
                ratings.getOurDrinksQuality(), ratings.getOurServiceQuality(),
                ratings.getOurCost());
    }
}
