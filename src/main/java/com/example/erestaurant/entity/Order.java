package com.example.erestaurant.entity;

import java.sql.Timestamp;
import java.util.List;

public class Order {
    private int id;
    private User user;
    // do I keep list of dishes or separate class ordered items?
    private List<Dish> dishes;
    private OrderStatus status;
    private Delivery delivery;
    private int totalPrice;
    private Timestamp orderSubmitTime;
}





