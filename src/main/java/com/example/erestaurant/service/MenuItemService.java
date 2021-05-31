package com.example.erestaurant.service;

import com.example.erestaurant.entity.MenuItem;
import com.example.erestaurant.entity.MenuItemCategory;
import com.example.erestaurant.exception.ObjectValidationException;
import com.example.erestaurant.exception.ServiceException;
import com.example.erestaurant.repository.IMenuItemRepository;
import com.example.erestaurant.util.ObjectValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MenuItemService implements IMenuItemService {

    private IMenuItemRepository menuItemRepository;
    private IMenuItemCategoryService menuItemCategoryService;

    @Autowired
    public MenuItemService(IMenuItemRepository menuItemRepository, IMenuItemCategoryService menuItemCategoryService) {
        this.menuItemRepository = menuItemRepository;
        this.menuItemCategoryService = menuItemCategoryService;
    }

    @Override
    public void add(MenuItem menuItem) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(menuItem);
            ObjectValidator.validateMenuItemFieldsForNull(menuItem);
            if (menuItemRepository.findByName(menuItem.getName()) == null) {
                menuItemRepository.save(menuItem);
                menuItem.getMenuItemCategory().getMenuItems().add(menuItem);
            } else {
                throw new ServiceException("Unable to add menu item: " + menuItem.getName() + ". It already exists in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public Optional<MenuItem> getById(int menuItemId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(menuItemId);
            return menuItemRepository.findById(menuItemId);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public MenuItem getByName(String menuItemName) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(menuItemName);
            return menuItemRepository.findByName(menuItemName);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public List<MenuItem> getByItemCategoryName(String menuItemCategoryName) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(menuItemCategoryName);
            return menuItemRepository.findByMenuItemCategoryName(menuItemCategoryName);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }

    }

    @Override
    public List<MenuItemCategory> getMenuItemCategories() {
        return menuItemCategoryService.getAllMenuItemCategories();
    }

    @Override
    public void delete(int menuItemId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(menuItemId);
            Optional<MenuItem> itemToDelete = getById(menuItemId);
            if (itemToDelete.isPresent()) {
                menuItemRepository.delete(itemToDelete.get());
            } else {
                throw new ServiceException("Unable to delete menu item with ID: " + menuItemId + ". Menu item is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }
}
