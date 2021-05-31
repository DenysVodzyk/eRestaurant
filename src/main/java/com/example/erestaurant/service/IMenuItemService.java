package com.example.erestaurant.service;

import com.example.erestaurant.entity.MenuItem;
import com.example.erestaurant.entity.MenuItemCategory;
import com.example.erestaurant.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface IMenuItemService {

    void add(MenuItem menuItem) throws ServiceException;

    List<MenuItem> getAllMenuItems();

    Optional<MenuItem> getById(int menuItemId) throws ServiceException;

    MenuItem getByName(String menuItemName) throws ServiceException;

    List<MenuItem> getByItemCategoryName(String menuItemCategoryName) throws ServiceException;

    List<MenuItemCategory> getMenuItemCategories();

    void delete(int menuItemId) throws ServiceException;
}
