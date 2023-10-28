package com.example.javasprintbootcardapio.repositories;

import com.example.javasprintbootcardapio.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
