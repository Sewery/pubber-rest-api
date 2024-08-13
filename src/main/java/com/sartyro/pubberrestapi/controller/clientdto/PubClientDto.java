package com.sartyro.pubberrestapi.controller.clientdto;


import jakarta.validation.constraints.Positive;
import lombok.*;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@Getter
@Builder
public class PubClientDto {
    @Positive
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
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
    private RatingsClientDto ratings;
    private List<OpeningHoursClientDto> openingHours;
    private List<DrinkClientDto> drinks;
    private List<PhotoClientDto> photos;
}
