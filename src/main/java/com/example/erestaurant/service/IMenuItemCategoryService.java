package com.example.erestaurant.service;

import com.example.erestaurant.entity.MenuItemCategory;
import com.example.erestaurant.exception.ObjectValidationException;
import com.example.erestaurant.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface IMenuItemCategoryService {

    void add(MenuItemCategory menuItemCategory) throws ServiceException;

    List<MenuItemCategory> getAllMenuItemCategories();

    Optional<MenuItemCategory> getById(int menuItemCategoryId) throws ServiceException;

    MenuItemCategory getMenuItemCategoryByName(String menuItemCategoryName) throws ServiceException;

    void delete(int menuItemCategoryId) throws ServiceException;
}
