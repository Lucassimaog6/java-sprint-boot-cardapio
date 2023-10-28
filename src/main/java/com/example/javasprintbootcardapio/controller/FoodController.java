package com.example.javasprintbootcardapio.controller;

import com.example.javasprintbootcardapio.models.Food;
import com.example.javasprintbootcardapio.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;
    @GetMapping
    public List<FoodResponse> getAll() {
        return foodRepository.findAll().stream().map(FoodResponse::new).toList();
    }

    @PostMapping
    public void create(@RequestBody FoodRequest request) {
        Food food = new Food(request);
        foodRepository.save(food);
        return;
    }
}

