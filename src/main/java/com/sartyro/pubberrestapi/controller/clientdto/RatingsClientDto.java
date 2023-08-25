package com.sartyro.pubberrestapi.controller.clientdto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;


@Builder
@Getter
public class RatingsClientDto {
    @PositiveOrZero
    private Float google;
    @PositiveOrZero
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
