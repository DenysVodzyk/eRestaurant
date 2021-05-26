package com.example.erestaurant.service;

import com.example.erestaurant.entity.Role;
import com.example.erestaurant.entity.User;
import com.example.erestaurant.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();

    Optional<User> getById(int id) throws ServiceException;

    User getByEmail(String email) throws ServiceException;

    User getByNameAndLastName(String name, String lastName) throws ServiceException;

    User getByIdAndPassword(int id, String password) throws ServiceException;

    void addUser(User user) throws ServiceException;

    void updateUserRole(int userId, Role role) throws ServiceException;

    void updateUserStatus(int userId, boolean isUserActive) throws ServiceException;

    void deleteUser(int userId) throws ServiceException;


}
