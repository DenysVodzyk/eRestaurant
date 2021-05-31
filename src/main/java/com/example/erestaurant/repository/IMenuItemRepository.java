package com.example.erestaurant.repository;

import com.example.erestaurant.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMenuItemRepository extends JpaRepository<MenuItem, Integer> {

    Optional<MenuItem> findById(int id);

    MenuItem findByName(String menuItemName);

    List<MenuItem> findByMenuItemCategoryName(String menuItemCategoryName);

}
