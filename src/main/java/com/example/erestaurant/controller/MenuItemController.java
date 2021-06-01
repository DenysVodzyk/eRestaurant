package com.example.erestaurant.controller;

import com.example.erestaurant.entity.MenuItem;
import com.example.erestaurant.entity.MenuItemCategory;
import com.example.erestaurant.exception.ServiceException;
import com.example.erestaurant.service.MenuItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/menu")
public class MenuItemController {

    private MenuItemService menuItemService;

    @PostMapping
    public ResponseEntity<MenuItem> addItem(@RequestBody MenuItem menuItem) {
        try {
            menuItemService.add(menuItem);
            return new ResponseEntity<>(menuItem, HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<MenuItem>> getAll() {
        try {
            return new ResponseEntity<>(menuItemService.getAllMenuItems(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category")
    public ResponseEntity<List<MenuItemCategory>> getMenuItemCategories() {
        try {
            return new ResponseEntity<>(menuItemService.getMenuItemCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{menuItemCategory}")
    public ResponseEntity<List<MenuItem>> getItemByMenuItemCategory(@PathVariable String menuItemCategory) {
        try {
            return new ResponseEntity<>(menuItemService.getByItemCategoryName(menuItemCategory), HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable int id) {
        try {
            menuItemService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
