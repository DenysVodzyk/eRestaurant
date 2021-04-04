package com.example.erestaurant.entity;

import java.sql.Timestamp;
import java.util.List;

public class CustomerOrder {
    private int id;
    private User user;
    private List<Dish> dishes;
    private Timestamp orderSubmitTime;
    private OrderStatus status;
    private int totalPrice;
}





