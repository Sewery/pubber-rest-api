package com.sartyro.pubberrestapi.controller.editdto;

import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;


@Builder
@Getter
public class RatingsEditDto {
    public final static Long EMPTY_ID=0L;
    @NotBlank
    private Long id;
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
