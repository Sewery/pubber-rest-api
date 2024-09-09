package com.sartyro.pubberrestapi.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
public class Geolocation {
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
}
