package com.example.javasprintbootcardapio.controller;

import com.example.javasprintbootcardapio.dtos.FoodDTO;
import com.example.javasprintbootcardapio.models.Food;
import com.example.javasprintbootcardapio.repositories.FoodRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/food")
    public ResponseEntity<List<Food>> getAllFoods() {
        return ResponseEntity.status(HttpStatus.OK).body(foodRepository.findAll());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/food/{id}")
    public ResponseEntity<?> getFoodById(@PathVariable(value = "id") Long id) {
        Optional<Food> food = foodRepository.findById(id);
        if (food.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food not found for ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(food);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/food")
    public ResponseEntity<Food> createFood(@RequestBody @Valid FoodDTO foodDTO) {
        Food food = new Food(foodDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(foodRepository.save(food));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/food/{id}")
    public ResponseEntity<Object> updateFoodById(@PathVariable(value = "id") Long id, @RequestBody @Valid FoodDTO foodDTO) {
        Optional<Food> existingFood = foodRepository.findById(id);
        if (existingFood.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food not found for ID: " + id);
        } else {
            Food food = existingFood.get();
            BeanUtils.copyProperties(foodDTO, food);
            return ResponseEntity.status(HttpStatus.OK).body(foodRepository.save(food));
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/food/{id}")
    public ResponseEntity<Object> deleteFoodById(@PathVariable(value = "id") Long id) {
        Optional<Food> existingFood = foodRepository.findById(id);
        if (existingFood.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food not found for ID: " + id);
        } else {
            Food food = existingFood.get();
            foodRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(food);
        }
    }


}

