package com.example.erestaurant.service;

import com.example.erestaurant.entity.Address;
import com.example.erestaurant.entity.PaymentCard;
import com.example.erestaurant.entity.Role;
import com.example.erestaurant.entity.User;
import com.example.erestaurant.exception.ObjectValidationException;
import com.example.erestaurant.exception.ServiceException;
import com.example.erestaurant.repository.IUserRepository;
import com.example.erestaurant.util.ObjectValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;
    private IAddressService addressService;
    private IPaymentCardService paymentCardService;

    @Autowired
    public UserService(IUserRepository userRepository, IAddressService addressService, IPaymentCardService paymentCardService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.paymentCardService = paymentCardService;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(int id) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(id);
            return userRepository.findById(id);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public User getByEmail(String email) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(email);
            return userRepository.findByEmail(email);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public User getByNameAndLastName(String name, String lastName) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(name);
            ObjectValidator.validateObjectForNull(lastName);
            return userRepository.findByNameAndLastName(name, lastName);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public User getByIdAndPassword(int id, String password) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(id);
            ObjectValidator.validateObjectForNull(password);
            return userRepository.findByIdAndPassword(id, password);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public void addUser(User user) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(user);
            ObjectValidator.validateUserFieldsForNull(user);
            if (getByEmail(user.getEmail()) == null) {
                userRepository.save(user);
            } else {
                throw new ServiceException("Unable to add user with email: " + user.getEmail() + ". Email already exists.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation of user object for null failed.");
        }
    }

    @Override
    public void updateUserRole(int userId, Role role) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(userId);
            ObjectValidator.validateObjectForNull(role);
            Optional<User> userToUpdate = getById(userId);
            if (userToUpdate.isPresent()) {
                userToUpdate.get().setRole(role);
                userRepository.save(userToUpdate.get());
            } else {
                throw new ServiceException("Unable to update user with ID: " + userId + ". User is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public void addUserAddress(int userId, Address address) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(userId);
            Optional<User> user = getById(userId);
            if (user.isPresent()) {
                address.setUser(user.get());
                addressService.add(address);
            } else {
                throw new ServiceException("Unable to add address to user with ID: " + userId + ". User is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public List<Address> getUserAddresses(int userId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(userId);
            Optional<User> user = getById(userId);
            if (user.isPresent()) {
                return addressService.getAddressByUserId(userId);
            } else {
                throw new ServiceException("User is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public void addPaymentCard(int userId, PaymentCard paymentCard) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(userId);
            Optional<User> user = getById(userId);
            if (user.isPresent()) {
                paymentCard.setUser(user.get());
                paymentCardService.add(paymentCard);
            } else {
                throw new ServiceException("Unable to add payment card to user with ID: " + userId + ". User is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public List<PaymentCard> getUserPaymentCards(int userId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(userId);
            Optional<User> user = getById(userId);
            if (user.isPresent()) {
                return paymentCardService.getPaymentCardByUserId(userId);
            } else {
                throw new ServiceException("User is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public void updateUserStatus(int userId, boolean isUserActive) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(userId);
            ObjectValidator.validateObjectForNull(isUserActive);
            Optional<User> userToUpdate = getById(userId);
            if (userToUpdate.isPresent()) {
                userToUpdate.get().setActive(isUserActive);
                userRepository.save(userToUpdate.get());
            } else {
                throw new ServiceException("Unable to update user with ID: " + userId + ". User is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public void deleteUser(int userId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(userId);
            Optional<User> userToDelete = getById(userId);
            if (userToDelete.isPresent()) {
                userRepository.delete(userToDelete.get());
            } else {
                throw new ServiceException("Unable to delete user with ID: " + userId + ". User is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }


}
