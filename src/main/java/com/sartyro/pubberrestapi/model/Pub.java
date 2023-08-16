package com.sartyro.pubberrestapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pub",updatable = false, nullable = false)
    private Long id;
    @Column(name = "place_id")
    private String placeId;
    private String city;
    private String address;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "website_url")
    private String websiteUrl;
    @Column(name = "icon_url")
    private String iconUrl;
    private String description;
    private Boolean reservable;
    private Boolean takeout;
    @OneToOne
    @JoinColumn(name = "id_rating")
    private Ratings rating;
    @OneToMany(mappedBy = "pub",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OpeningHours> openingHours;
    @ManyToMany
    @JoinTable(name="Drink_Pub",
            joinColumns = @JoinColumn(name = "id_pub"),
            inverseJoinColumns = @JoinColumn(name = "id_drink")
    )
    private List<Drink> drinks;

    @OneToMany(mappedBy = "pub",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Photo> photos;



}
