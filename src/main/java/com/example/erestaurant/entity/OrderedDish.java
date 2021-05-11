package com.example.erestaurant.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ordered_dish")
public class OrderedDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cusomer_order_id")
    private CustomerOrder customerOrder;

    @OneToMany(mappedBy = "orderedDish")
    private List<Dish> dishes;

    public OrderedDish() {
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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "OrderedDish{" +
                "id=" + id +
                ", customerOrder=" + customerOrder +
                ", dishes=" + dishes +
                '}';
    }
}
