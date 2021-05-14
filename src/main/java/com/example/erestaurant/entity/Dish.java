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
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "dish_status")
    private DishStatus dishStatus;

    @Column(name = "quantity")
    private int quantity;

    public Dish() {
    }

    public Dish(int id, DishStatus dishStatus, int quantity) {
        this.id = id;
        this.dishStatus = dishStatus;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishStatus=" + dishStatus +
                ", quantity=" + quantity +
                '}';
    }
}
