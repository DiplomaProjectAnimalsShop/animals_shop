package com.example.animals_shop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "animal_feature")
public class AnimalFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private Double age;
    @Column
    private String color;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column
    private Double weight;
    @Column
    private String breed;
    @Column
    private String size;
    @ManyToOne
    private Post post;
}
