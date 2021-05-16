package com.example.erestaurant.repository;

import com.example.erestaurant.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuItemRepository extends JpaRepository<MenuItem, Integer> {
}
