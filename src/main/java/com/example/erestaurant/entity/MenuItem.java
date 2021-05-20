package com.example.erestaurant.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "menu_item")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "menu_item_category_id")
    private MenuItemCategory menuItemCategory;

    @Column(name = "price")
    private int price;

    @Column(name = "is_kitchen_made")
    private boolean isKitchenMade;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "is_active")
    private boolean isActive;

}



