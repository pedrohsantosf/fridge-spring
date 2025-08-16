package dev.santos.fridge_spring_study.repository;

import dev.santos.fridge_spring_study.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
