package com.sartyro.pubberrestapi.dto.editdto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.sartyro.pubberrestapi.util.Constants.EMPTY_ID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkStylesEditRequestDto {
    @PositiveOrZero
    @JsonIgnore
    private Long id;
    @NotBlank(message = "Style name field can't be blank")
    private String styleName;
}
