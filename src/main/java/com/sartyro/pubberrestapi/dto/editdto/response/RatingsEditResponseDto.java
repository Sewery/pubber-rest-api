package com.sartyro.pubberrestapi.dto.editdto.response;

public record RatingsEditResponseDto(
        Float google,
        Integer googleCount,
        Float facebook,
        Integer facebookCount,
        Float tripAdvisor,
        Integer tripAdvisorCount,
        Float untapped,
        Integer untappedCount,
        Float ourDrinksQuality,
        Float ourServiceQuality,
        Integer ourCost
) {
}