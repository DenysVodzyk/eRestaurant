package com.example.erestaurant.service;

import com.example.erestaurant.entity.Dish;
import com.example.erestaurant.entity.DishStatus;

import java.util.List;
import java.util.Optional;

public interface IDishService {

    void addDish(Dish dish);

    List<Dish> getAll();

    Optional<Dish> getById(int dishId);

    void deleteDish(int dishId);

    void pushDishStatus(int dishId, DishStatus newDishStatus);
}
