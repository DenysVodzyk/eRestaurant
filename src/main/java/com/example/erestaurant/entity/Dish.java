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
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "dish_status")
    private DishStatus dishStatus;

    public Dish() {
    }

    public Dish(int price, DishCategory category, boolean isKitchenMade, String ingredients, boolean isActive, DishStatus dishStatus) {
        this.price = price;
        this.dishCategory = category;
        this.isKitchenMade = isKitchenMade;
        this.ingredients = ingredients;
        this.isActive = isActive;
        this.dishStatus = dishStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public DishStatus getDishStatus() {
        return dishStatus;
    }

    public void setDishStatus(DishStatus dishStatus) {
        this.dishStatus = dishStatus;
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
                ", customerOrder=" + customerOrder +
                ", category=" + dishCategory +
                ", price=" + price +
                ", isKitchenMade=" + isKitchenMade +
                ", ingredients='" + ingredients + '\'' +
                ", isActive=" + isActive +
                ", dishStatus=" + dishStatus +
                '}';
    }
}



