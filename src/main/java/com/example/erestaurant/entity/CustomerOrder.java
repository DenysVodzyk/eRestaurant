package com.example.erestaurant.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private User user;
    private List<Dish> dishes;
    private LocalDateTime orderSubmitTime;
    private OrderStatus status;
    private int totalPrice;

    public CustomerOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public LocalDateTime getOrderSubmitTime() {
        return orderSubmitTime;
    }

    public void setOrderSubmitTime(LocalDateTime orderSubmitTime) {
        this.orderSubmitTime = orderSubmitTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", user=" + user +
                ", dishes=" + dishes +
                ", orderSubmitTime=" + orderSubmitTime +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                '}';
    }
}






