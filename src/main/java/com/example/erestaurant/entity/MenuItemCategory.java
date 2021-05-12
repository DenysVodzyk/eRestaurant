package com.example.erestaurant.entity;

import javax.persistence.*;
import java.util.List;

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

    public MenuItemCategory() {
    }

    public MenuItemCategory(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MenuItemCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

