package com.sartyro.pubberrestapi.model;



import jakarta.persistence.*;
import lombok.*;


import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_drink",nullable = false)
    private Long id;
    @Column(name="drink_name")
    private String name;
    private String type;
    @Column(name="drink_description")
    private String description;
    @ManyToMany(mappedBy = "drinks")
    private List<Pub> pubs;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Drink_Styles_Drink",
            joinColumns = @JoinColumn(name = "id_drink"),
            inverseJoinColumns = @JoinColumn(name = "id_drink_style")
    )
    private List<DrinkStyles> drinkStyles;
}
