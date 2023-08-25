package com.sartyro.pubberrestapi.controller.editdto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import lombok.Setter;


@Builder
@Getter
@Setter
public class RatingsEditDto {
    public final static Long EMPTY_ID=0L;
    @PositiveOrZero
    private Long id;
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
