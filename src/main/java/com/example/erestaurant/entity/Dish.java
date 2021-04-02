package com.example.erestaurant.entity;

import java.util.List;

public class Dish {
    private int id;
    private DishCategory category;
    private boolean isKitchenMade;
    private List<Ingredient> ingredients;
    private int price;
    private DishStatus status;
    private boolean isActive;
}



