package dev.santos.fridge_spring_study.controller;

import dev.santos.fridge_spring_study.model.Food;
import dev.santos.fridge_spring_study.services.FoodService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fridge")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getAll() {return foodService.getAll();}

    @PostMapping
    public Food create(@RequestBody Food food) {return foodService.save(food);}

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {foodService.delete(id);}
}
