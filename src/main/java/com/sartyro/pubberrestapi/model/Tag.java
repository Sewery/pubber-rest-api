package com.sartyro.pubberrestapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tag",nullable = false)
    private Long id;
    @NotNull
    private String name;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_pub")
    @JsonBackReference
    private Pub pub;
}
