package com.sartyro.pubberrestapi.controller.editdto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Setter
public class PubEditDto {
    public final static Long EMPTY_ID=0L;
    @PositiveOrZero
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
    private Double latitude;
    private Double longitude;
    private Boolean reservable;
    private Boolean takeout;
    private RatingsEditDto ratings;
    private List<OpeningHoursEditDto> openingHours;
    private List<DrinkEditDto> drinks;
    private List<PhotoEditDto> photos;
}
