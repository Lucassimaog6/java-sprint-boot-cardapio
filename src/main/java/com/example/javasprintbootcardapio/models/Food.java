package com.example.javasprintbootcardapio.models;

import com.example.javasprintbootcardapio.controller.FoodRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "food")
@Entity(name = "food")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public Food(FoodRequest foodRequest) {
        this.image = foodRequest.image();
        this.title = foodRequest.title();
        this.price = foodRequest.price();
    }
}
