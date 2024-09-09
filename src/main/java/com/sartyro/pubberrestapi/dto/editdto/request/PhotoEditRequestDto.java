package com.sartyro.pubberrestapi.dto.editdto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

import static com.sartyro.pubberrestapi.util.Constants.EMPTY_ID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoEditRequestDto {
    @PositiveOrZero
    @JsonIgnore
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String photoUrl;
}
