package com.example.erestaurant.service;

import com.example.erestaurant.entity.Dish;
import com.example.erestaurant.entity.DishStatus;

import java.util.List;
import java.util.Optional;

public class DishService implements IDishService {
    @Override
    public void addDish(Dish dish) {

    }

    @Override
    public List<Dish> getAll() {
        return null;
    }

    @Override
    public Optional<Dish> getById(int dishId) {
        return Optional.empty();
    }

    @Override
    public void deleteDish(int dishId) {

    }

    @Override
    public void pushDishStatus(int dishId, DishStatus newDishStatus) {

    }
}
