package com.example.erestaurant.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_order_dish")
public class CustomerOrderDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

    @OneToMany(mappedBy = "customerOrderDish")
    private List<Dish> dishes;

    public CustomerOrderDish() {
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
                '}';
    }
}
