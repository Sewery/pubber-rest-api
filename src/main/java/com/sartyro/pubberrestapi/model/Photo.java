package com.sartyro.pubberrestapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_add_photo",nullable = false)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_pub")
    @JsonBackReference
    private Pub pub;
    private String title;
    @Column(name = "photo_url")
    private String photoUrl;
}
