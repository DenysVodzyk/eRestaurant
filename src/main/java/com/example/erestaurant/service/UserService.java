package com.example.erestaurant.service;

import com.example.erestaurant.entity.Role;
import com.example.erestaurant.entity.User;
import com.example.erestaurant.exception.ObjectValidationException;
import com.example.erestaurant.exception.ServiceException;
import com.example.erestaurant.repository.IUserRepository;
import com.example.erestaurant.util.ObjectValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(id);
            return userRepository.findById(id);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation Failed.");
        }
    }

    @Override
    public User findByEmail(String email) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(email);
            return userRepository.findByEmail(email);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation Failed.");
        }
    }

    @Override
    public User findByNameAndLastName(String name, String lastName) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(name);
            ObjectValidator.validateObjectForNull(lastName);
            return userRepository.findByNameAndLastName(name, lastName);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation Failed.");
        }
    }

    @Override
    public User findByIdAndPassword(int id, String password) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(id);
            ObjectValidator.validateObjectForNull(password);
            return userRepository.findByIdAndPassword(id, password);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation Failed.");
        }
    }

    @Override
    @Transactional
    public void addUser(User user) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(user);
            ObjectValidator.validateUserFieldsForNull(user);
            if (findByEmail(user.getEmail()) == null) {
                userRepository.save(user);
            } else {
                throw new ServiceException("Unable to add user with email: " + user.getEmail() + ". Email already exists.");
            }
        } catch (ObjectValidationException | ServiceException e) {
            e.printStackTrace();
            throw new ServiceException("Validation of user object for null failed.");
        }
    }

    @Override
    @Transactional
    public void updateUserRole(User user, Role role) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(user);
            ObjectValidator.validateObjectForNull(role);
            ObjectValidator.validateUserFieldsForNull(user);
            User userToUpdate = findByEmail(user.getEmail());
            if (userToUpdate != null) {
                userToUpdate.setRole(role);
                userRepository.save(userToUpdate);
            } else {
                throw new ServiceException("Unable to update user " + user.getEmail() + ". User is not registered in the database.");
            }

        } catch (ObjectValidationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserStatus(User user, boolean isUserActive) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(user);
            ObjectValidator.validateObjectForNull(isUserActive);
            ObjectValidator.validateUserFieldsForNull(user);
            User userToUpdate = findByEmail(user.getEmail());
            if (userToUpdate != null) {
                userToUpdate.setActive(isUserActive);
                userRepository.save(userToUpdate);
            } else {
                throw new ServiceException("Unable to update user " + user.getEmail() + ". User is not registered in the database.");
            }

        } catch (ObjectValidationException e) {
            e.printStackTrace();
        }

    }


    //add address


    @Override
    @Transactional
    public void deleteUser(User user) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(user);
            ObjectValidator.validateUserFieldsForNull(user);
            if (findByEmail(user.getEmail()) != null) {
                userRepository.delete(user);
            } else {
                throw new ServiceException("Unable to delete user " + user.getEmail() + ". User is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
        }

    }


}
