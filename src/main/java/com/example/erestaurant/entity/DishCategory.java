package com.example.erestaurant.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish_category")
public class DishCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "dishCategory")
    private List<Dish> dishes;

    @Column(name = "name")
    private String name;

    public DishCategory() {
    }

    public DishCategory(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DishCategory{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", name='" + name + '\'' +
                '}';
    }
}

