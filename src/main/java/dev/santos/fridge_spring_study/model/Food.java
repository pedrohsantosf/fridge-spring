package dev.santos.fridge_spring_study.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="food_table")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime expirationDate;
    private int quantity;

    public Food() {
    }

    public Food(Long id, String name, LocalDateTime expirationDate, int quantity) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }
}
