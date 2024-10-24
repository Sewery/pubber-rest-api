package com.sartyro.pubberrestapi.dto.editdto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeerEditRequestDto {
    @Positive
    @JsonIgnore
    private Long beerId;
    private String longDescription;
    private String shortDescription;
    private String photoUrl;
    private String maltiness;
    private String blg;
    private String alcoholContent;
}
