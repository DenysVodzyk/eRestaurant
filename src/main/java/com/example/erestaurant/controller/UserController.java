package com.example.erestaurant.controller;

import com.example.erestaurant.entity.Role;
import com.example.erestaurant.entity.User;
import com.example.erestaurant.exception.ServiceException;
import com.example.erestaurant.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        try {
            return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        try {
            Optional<User> user = userService.getById(id);
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/users/{id}/role")
    public ResponseEntity<HttpStatus> updateUserRole(@PathVariable int id, Role newRole) {
        try {
            userService.updateUserRole(id, newRole);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
