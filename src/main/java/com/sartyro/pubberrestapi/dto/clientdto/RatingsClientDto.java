package com.sartyro.pubberrestapi.dto.clientdto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class RatingsClientDto {
    private Float google;
    private Integer googleCount;
    private Float facebook;
    private Integer facebookCount;
    private Float tripAdvisor;
    private Integer tripAdvisorCount;
    private Float untapped ;
    private Integer untappedCount;
    private Float ourDrinksQuality;
    private Float ourServiceQuality;
    private Integer ourCost;
}
