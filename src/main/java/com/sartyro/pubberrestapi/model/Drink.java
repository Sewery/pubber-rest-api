package com.sartyro.pubberrestapi.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_drink",nullable = false)
    private Long id;
    private String name;
    private String type;
    @ManyToMany(mappedBy = "drinks")
    private List<Pub> pubs;
}
