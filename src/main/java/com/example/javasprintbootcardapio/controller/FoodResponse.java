package com.example.javasprintbootcardapio.controller;

import com.example.javasprintbootcardapio.models.Food;

public record FoodResponse(Long id, String title, String image, Integer price) {
    public FoodResponse(Food food){
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
