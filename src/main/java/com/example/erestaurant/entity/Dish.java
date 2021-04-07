package com.example.erestaurant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int price;
    private DishCategory category;
    private boolean isKitchenMade;
    private String ingredients;
    private boolean isActive;

    public Dish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DishCategory getCategory() {
        return category;
    }

    public void setCategory(DishCategory category) {
        this.category = category;
    }

    public boolean isKitchenMade() {
        return isKitchenMade;
    }

    public void setKitchenMade(boolean kitchenMade) {
        isKitchenMade = kitchenMade;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", price=" + price +
                ", category=" + category +
                ", isKitchenMade=" + isKitchenMade +
                ", ingredients='" + ingredients + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}



