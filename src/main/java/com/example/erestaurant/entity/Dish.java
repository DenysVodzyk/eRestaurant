package com.example.erestaurant.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    @JsonBackReference
    private MenuItem menuItem;

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    @JsonBackReference
    private CustomerOrder customerOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "dish_status")
    private DishStatus dishStatus;

    @Column(name = "quantity")
    private int quantity;

}
