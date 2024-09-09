package com.sartyro.pubberrestapi.dto.editdto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingsEditRequestDto {
    @PositiveOrZero
    @JsonIgnore
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
