package com.example.erestaurant.repository;

import com.example.erestaurant.entity.MenuItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuItemCategoryRepository extends JpaRepository<MenuItemCategory, Integer> {
}
