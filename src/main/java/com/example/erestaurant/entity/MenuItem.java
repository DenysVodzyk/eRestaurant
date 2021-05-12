package com.example.erestaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ordered_dish_id")
    private OrderedDish orderedDish;

    @ManyToOne
    @JoinColumn(name = "dish_category_id")
    private DishCategory dishCategory;

    @Column(name = "price")
    private int price;

    @Column(name = "is_kitchen_made")
    private boolean isKitchenMade;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "is_active")
    private boolean isActive;

    public Dish() {
    }

    public Dish(int price, DishCategory category, boolean isKitchenMade, String ingredients, boolean isActive) {
        this.price = price;
        this.dishCategory = category;
        this.isKitchenMade = isKitchenMade;
        this.ingredients = ingredients;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderedDish getOrderedDish() {
        return orderedDish;
    }

    public void setOrderedDish(OrderedDish orderedDish) {
        this.orderedDish = orderedDish;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DishCategory getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(DishCategory category) {
        this.dishCategory = category;
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
                ", category=" + dishCategory +
                ", price=" + price +
                ", isKitchenMade=" + isKitchenMade +
                ", ingredients='" + ingredients + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}



