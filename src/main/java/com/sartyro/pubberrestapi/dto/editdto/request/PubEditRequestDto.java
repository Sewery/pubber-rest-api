package com.sartyro.pubberrestapi.dto.editdto.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sartyro.pubberrestapi.validation.IdentityIdArray;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PubEditRequestDto {
    @PositiveOrZero
    @JsonIgnore
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String placeId;
    @NotBlank
    private String city;
    @NotBlank
    @Pattern(regexp = "^(\\+\\d{2}\\s?)?((\\d{9})|(\\d{2}\\s\\d{3}\\s\\d{2}\\s\\d{2})|((\\d{3}\\s){2}\\d{3}))")
    private String phoneNumber;
    @NotBlank
    @Pattern(regexp = "^(https?:\\/\\/).*")
    private String websiteUrl;
    @NotBlank
    @Pattern(regexp = "^(https?:\\/\\/).*")
    private String iconUrl;
    @NotBlank
    private String description;
    private Double latitude;
    private Double longitude;
    private Boolean reservable;
    private Boolean takeout;
    private RatingsEditRequestDto ratings;
    @IdentityIdArray
    private List<Long> drinksIDs;
}
