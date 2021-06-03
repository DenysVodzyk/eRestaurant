package com.example.erestaurant.repository;

import com.example.erestaurant.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDishRepository extends JpaRepository<Dish, Integer> {

    Optional<Dish> findById(int id);

}
