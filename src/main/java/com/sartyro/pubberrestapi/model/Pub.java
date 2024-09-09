package com.sartyro.pubberrestapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pub",updatable = false, nullable = false)
    private Long id;
    @NotNull
    @Column(name = "pub_name")
    private String name;
    @NotNull
    private String address;
    @NotNull
    @Column(name = "place_id")
    private String placeId;
    @NotNull
    private String city;
    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotNull
    @Column(name = "website_url")
    private String websiteUrl;
    @NotNull
    @Column(name = "icon_url")
    private String iconUrl;
    @NotNull
    private String description;
    @NotNull
    @Embedded
    @JsonUnwrapped
    private Geolocation geoLocation;
    @NotNull
    private Boolean reservable;
    @NotNull
    private Boolean takeout;
    @NotNull
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rating")
    private Ratings rating;
    @OneToMany(mappedBy = "pub",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OpeningHours> openingHours;
    @ManyToMany
    @JoinTable(name="Drink_Pub",
            joinColumns = @JoinColumn(name = "id_pub"),
            inverseJoinColumns = @JoinColumn(name = "id_drink")
    )
    private List<Drink> drinks;
    @OneToMany(mappedBy = "pub",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Photo> photos;
    @OneToMany(mappedBy = "pub",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Tag> tags;



}
