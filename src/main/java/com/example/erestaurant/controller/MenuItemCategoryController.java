package com.example.erestaurant.controller;

import com.example.erestaurant.entity.MenuItemCategory;
import com.example.erestaurant.exception.ServiceException;
import com.example.erestaurant.service.IMenuItemCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/menu/category")
public class MenuItemCategoryController {

    private IMenuItemCategoryService menuItemCategoryService;

    @PostMapping
    public ResponseEntity<MenuItemCategory> addCategory(@RequestBody MenuItemCategory menuItemCategory) {
        try {
            menuItemCategoryService.add(menuItemCategory);
            return new ResponseEntity<>(menuItemCategory, HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable int id) {
        try {
            menuItemCategoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
