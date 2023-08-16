package com.sartyro.pubberrestapi.controller.clientdto;

import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;


@Builder
@Getter
public class RatingsClientDto {
    @NotBlank
    private Float google;
    @NotBlank
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
