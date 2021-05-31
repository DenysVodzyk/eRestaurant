package com.example.erestaurant.service;

import com.example.erestaurant.entity.MenuItemCategory;
import com.example.erestaurant.exception.ObjectValidationException;
import com.example.erestaurant.exception.ServiceException;
import com.example.erestaurant.repository.IMenuItemCategoryRepository;
import com.example.erestaurant.util.ObjectValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MenuItemCategoryService implements IMenuItemCategoryService {
    private IMenuItemCategoryRepository menuItemCategoryRepository;

    @Autowired
    public MenuItemCategoryService(IMenuItemCategoryRepository menuItemCategoryRepository) {
        this.menuItemCategoryRepository = menuItemCategoryRepository;
    }

    @Override
    public void add(MenuItemCategory menuItemCategory) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(menuItemCategory);
            ObjectValidator.validateMenuItemCategoryFieldsForNull(menuItemCategory);
            if (menuItemCategoryRepository.findMenuItemCategoryByName(menuItemCategory.getName()) == null) {
                menuItemCategoryRepository.save(menuItemCategory);
            } else {
                throw new ServiceException("Unable to add menu item category: " + menuItemCategory.getName() + ". It already exists in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public List<MenuItemCategory> getAllMenuItemCategories() {
        return menuItemCategoryRepository.findAll();
    }

    @Override
    public Optional<MenuItemCategory> getById(int menuItemCategoryId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(menuItemCategoryId);
            return menuItemCategoryRepository.findById(menuItemCategoryId);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public MenuItemCategory getMenuItemCategoryByName(String menuItemCategoryName) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(menuItemCategoryName);
            return menuItemCategoryRepository.findMenuItemCategoryByName(menuItemCategoryName);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public void delete(int menuItemCategoryId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(menuItemCategoryId);
            Optional<MenuItemCategory> categoryToDelete = getById(menuItemCategoryId);
            if (categoryToDelete.isPresent()) {
                menuItemCategoryRepository.delete(categoryToDelete.get());
            } else {
                throw new ServiceException("Unable to delete menu item category with ID: " + menuItemCategoryId + ". Menu item category is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }
}
