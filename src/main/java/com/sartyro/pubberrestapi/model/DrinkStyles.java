package com.sartyro.pubberrestapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Drink_Styles")
public class DrinkStyles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_drink_style",nullable = false)
    private Long id;
    @Column(name="style_name")
    private String styleName;
    @ManyToMany(mappedBy = "drinkStyles", fetch = FetchType.EAGER)
    private List<Drink> drinks;
}
