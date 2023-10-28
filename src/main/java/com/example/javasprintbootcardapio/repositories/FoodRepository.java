package com.example.javasprintbootcardapio.repositories;

import com.example.javasprintbootcardapio.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
