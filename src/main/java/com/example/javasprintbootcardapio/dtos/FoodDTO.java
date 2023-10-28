package com.example.javasprintbootcardapio.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record FoodDTO(@NotBlank String title, @NotNull String image, Integer price) { }
