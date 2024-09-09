package com.sartyro.pubberrestapi.dto.editdto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sartyro.pubberrestapi.validation.IdentityIdArray;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.sartyro.pubberrestapi.util.Constants.EMPTY_ID;



@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkEditRequestDto {
    @PositiveOrZero
    @JsonIgnore
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotBlank
    private String description;
    @IdentityIdArray
    private List<Long> drinkStylesIDs;
}
