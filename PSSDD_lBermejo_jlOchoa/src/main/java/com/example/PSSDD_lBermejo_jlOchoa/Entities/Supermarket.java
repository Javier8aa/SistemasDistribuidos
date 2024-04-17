package com.example.PSSDD_lBermejo_jlOchoa.Entities;

import lombok.*;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Supermarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    @OneToMany(mappedBy = "supermarket")
    private Set<com.example.PSSDD_lBermejo_jlOchoa.Entities.Aisle> aisles = new HashSet<>();

    public Supermarket(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
