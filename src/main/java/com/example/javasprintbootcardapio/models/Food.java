package com.example.javasprintbootcardapio.models;

import com.example.javasprintbootcardapio.dtos.FoodDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "food")
@Entity(name = "food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public Food(FoodDTO foodDTO) {
        this.title = foodDTO.title();
        this.image = foodDTO.image();
        this.price = foodDTO.price();
    }
}
