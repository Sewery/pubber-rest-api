package com.sartyro.pubberrestapi.dto.clientdto;


import jakarta.validation.constraints.Positive;
import lombok.*;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.List;
@Builder
@Getter
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
    @Pattern(
            regexp = "^(\\+\\d{2}\\s?)?((\\d{9})|(\\d{2}\\s\\d{3}\\s\\d{2}\\s\\d{2})|((\\d{3}\\s){2}\\d{3}))",
            message = "Invalid phone number format. Please use one of the following formats: +XX XXXXXXXXX, XX XXX XX XX, or XXX XXX XXX."
    )
    private String phoneNumber;
    @Pattern(
            regexp = "^(https?:\\/\\/).*",
            message = "Invalid URL format. The URL must start with 'http://' or 'https://'."
    )
    private String websiteUrl;
    @Pattern(
            regexp = "^(https?:\\/\\/).*",
            message = "Invalid URL format. The URL must start with 'http://' or 'https://'."
    )
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
    private List<TagClientDto> tags;
}
