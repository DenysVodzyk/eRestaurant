package com.example.erestaurant.controller;

import com.example.erestaurant.entity.User;
import com.example.erestaurant.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private IUserService userService;

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.findAll();
    }
}
