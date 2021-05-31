package com.example.erestaurant.repository;

import com.example.erestaurant.entity.MenuItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMenuItemCategoryRepository extends JpaRepository<MenuItemCategory, Integer> {

    Optional<MenuItemCategory> findById(int id);

    MenuItemCategory findMenuItemCategoryByName(String categoryName);

}
