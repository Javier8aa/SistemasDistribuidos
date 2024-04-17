package com.example.PSSDD_lBermejo_jlOchoa.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.HashSet;

@Entity //Entity JPA by data table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double price;

    @ManyToMany(mappedBy = "foods") //relation mapped by atribute foods in aisle
    private Set<Aisle> aisles = new HashSet<>();//Aisles which constains the food

    public Food(String n, Double p) {
        this.name = n;
        this.price = p;
    }
}
