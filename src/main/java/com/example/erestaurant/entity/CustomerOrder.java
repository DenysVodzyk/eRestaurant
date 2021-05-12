package com.example.erestaurant.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "customerOrder")
    private List<CustomerOrderDish> customerOrderDish;

    @Column(name = "order_submit_time")
    private LocalDateTime orderSubmitTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "total_price")
    private int totalPrice;

    public CustomerOrder() {
    }

    public CustomerOrder(LocalDateTime orderSubmitTime, OrderStatus status, int totalPrice) {
        this.orderSubmitTime = orderSubmitTime;
        this.status = status;
        this.totalPrice = totalPrice;
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

    public List<CustomerOrderDish> getCustomerOrderDish() {
        return customerOrderDish;
    }

    public void setCustomerOrderDish(List<CustomerOrderDish> orderedDishes) {
        this.customerOrderDish = orderedDishes;
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
                ", orderedDishes=" + customerOrderDish +
                ", orderSubmitTime=" + orderSubmitTime +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                '}';
    }
}






