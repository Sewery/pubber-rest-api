package com.sartyro.pubberrestapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Beer")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_beer",nullable = false)
    private Long id;

    @NotNull
    @Column(name="long_description")
    private String longDescription;

    @NotNull
    @Column(name="short_description")
    private String shortDescription;

    @Column(name="photo_url")
    private String photoUrl;

    @Column(name="maltiness")
    private String maltiness;

    @Column(name="blg")
    private String blg;
    @Column(name="alcohol_content")
    private String alcoholContent;
}
