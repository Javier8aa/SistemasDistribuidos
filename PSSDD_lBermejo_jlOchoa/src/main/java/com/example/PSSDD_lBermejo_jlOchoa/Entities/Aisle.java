package com.example.PSSDD_lBermejo_jlOchoa.Entities;

import lombok.*;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Aisle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "supermarket_id")
    private Supermarket supermarket;

    @ManyToMany
    @JoinTable(
            name = "aisle_food",
            joinColumns = @JoinColumn(name = "aisle_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private Set<com.example.PSSDD_lBermejo_jlOchoa.Entities.Food> foods = new HashSet<>();

    public Aisle(String name, boolean available, Supermarket supermarket, Set<com.example.PSSDD_lBermejo_jlOchoa.Entities.Food> foods) {
        this.name = name;
        this.available = available;
        this.supermarket = supermarket;
        this.foods = foods;
    }
}
