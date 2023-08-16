package com.sartyro.pubberrestapi.controller.editdto;


import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@Getter
@Builder
public class PubEditDto {
    public final static Long EMPTY_ID=null;
    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String placeId;
    @NotBlank
    private String city;
    @Pattern(regexp = "^(\\+\\d{2}\\s?)?((\\d{9})|(\\d{2}\\s\\d{3}\\s\\d{2}\\s\\d{2})|((\\d{3}\\s){2}\\d{3}))")
    private String phoneNumber;
    @Pattern(regexp = "^(https?:\\/\\/).*")
    private String websiteUrl;
    @Pattern(regexp = "^(https?:\\/\\/).*")
    private String iconUrl;
    private String description;
    private Boolean reservable;
    private Boolean takeout;
    private RatingsEditDto ratings;
    private List<OpeningHoursEditDto> openingHours;
    private List<DrinkEditDto> drinks;
    private List<PhotoEditDto> photos;
}
