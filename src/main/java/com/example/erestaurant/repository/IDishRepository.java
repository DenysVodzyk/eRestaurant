package com.example.erestaurant.repository;

import com.example.erestaurant.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDishRepository extends JpaRepository<Dish, Integer> {
}
