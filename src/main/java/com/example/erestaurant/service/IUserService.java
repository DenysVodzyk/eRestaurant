package com.example.erestaurant.service;

import com.example.erestaurant.entity.Role;
import com.example.erestaurant.entity.User;
import com.example.erestaurant.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();

    Optional<User> findById(int id) throws ServiceException;

    User findByEmail(String email) throws ServiceException;

    User findByNameAndLastName(String name, String lastName) throws ServiceException;

    User findByIdAndPassword(int id, String password) throws ServiceException;

    void addUser(User user) throws ServiceException;

    void updateUserRole(User user, Role role) throws ServiceException;

    void updateUserStatus(User user, boolean isUserActive) throws ServiceException;

    void deleteUser(User user) throws ServiceException;


}
