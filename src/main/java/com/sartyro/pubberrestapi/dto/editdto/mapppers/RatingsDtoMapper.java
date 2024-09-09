package com.sartyro.pubberrestapi.dto.editdto.mapppers;

import com.sartyro.pubberrestapi.dto.editdto.request.RatingsEditRequestDto;
import com.sartyro.pubberrestapi.dto.editdto.response.RatingsEditResponseDto;
import com.sartyro.pubberrestapi.model.Ratings;
import com.sartyro.pubberrestapi.util.Constants;

public class RatingsDtoMapper {
    private RatingsDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    // Map from request DTO to entity
    public static Ratings fromRequestToEntity(RatingsEditRequestDto request) {
        if(request==null)
            return null;
        return new Ratings(
                Constants.EMPTY_ID,
                request.getGoogle(),
                request.getGoogleCount(),
                request.getFacebook(),
                request.getFacebookCount(),
                request.getTripAdvisor(),
                request.getTripAdvisorCount(),
                request.getUntapped(),
                request.getUntappedCount(),
                request.getOurDrinksQuality(),
                request.getOurServiceQuality(),
                request.getOurCost()
        );
    }
    public static Ratings fromRequestToEntity(RatingsEditRequestDto request, Long id) {
        if(request==null)
            return null;
        return new Ratings(
                id,
                request.getGoogle(),
                request.getGoogleCount(),
                request.getFacebook(),
                request.getFacebookCount(),
                request.getTripAdvisor(),
                request.getTripAdvisorCount(),
                request.getUntapped(),
                request.getUntappedCount(),
                request.getOurDrinksQuality(),
                request.getOurServiceQuality(),
                request.getOurCost()
        );
    }

    // Map from entity to response DTO
    public static RatingsEditResponseDto fromEntityToResponse(Ratings entity) {
        if(entity==null)
            return null;
        return new RatingsEditResponseDto(
                entity.getGoogle(),
                entity.getGoogleCount(),
                entity.getFacebook(),
                entity.getFacebookCount(),
                entity.getTripAdvisor(),
                entity.getTripAdvisorCount(),
                entity.getUntapped(),
                entity.getUntappedCount(),
                entity.getOurDrinkQuality(),
                entity.getOurServiceQuality(),
                entity.getOurCost()
        );
    }
}