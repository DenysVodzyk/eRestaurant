package com.example.erestaurant.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "menu_item_category")
public class MenuItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "menuItemCategory")
    private List<MenuItem> menuItems;

    @Column(name = "name")
    private String name;

}

