package com.example.erestaurant.entity;

import javax.persistence.*;

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

    public MenuItem() {
    }

    public MenuItem(int id, int price, boolean isKitchenMade, String ingredients, boolean isActive) {
        this.id = id;
        this.price = price;
        this.isKitchenMade = isKitchenMade;
        this.ingredients = ingredients;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public MenuItemCategory getMenuItemCategory() {
        return menuItemCategory;
    }

    public void setMenuItemCategory(MenuItemCategory category) {
        this.menuItemCategory = category;
    }

    public boolean isKitchenMade() {
        return isKitchenMade;
    }

    public void setKitchenMade(boolean kitchenMade) {
        isKitchenMade = kitchenMade;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", price=" + price +
                ", isKitchenMade=" + isKitchenMade +
                ", ingredients='" + ingredients + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}



