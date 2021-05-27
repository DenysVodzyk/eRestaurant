package com.example.erestaurant.service;

import com.example.erestaurant.entity.Address;
import com.example.erestaurant.entity.User;
import com.example.erestaurant.exception.ObjectValidationException;
import com.example.erestaurant.exception.ServiceException;
import com.example.erestaurant.repository.IAddressRepository;
import com.example.erestaurant.util.ObjectValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AddressService implements IAddressService {

    private IAddressRepository addressRepository;

    @Autowired
    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void add(Address address) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(address);
            ObjectValidator.validateAddressForNull(address);
            ObjectValidator.validateObjectForNull(address.getUser());
            ObjectValidator.validateUserFieldsForNull(address.getUser());

            if (addressRepository.findByUserAndAddressLine1(address.getUser(), address.getAddressLine1()) == null) {
                addressRepository.save(address);
            } else {
                throw new ServiceException("Unable to add address with address line: " + address.getAddressLine1() + " for user with id: " + address.getUser().getId() + ". Address line 1 already exists.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation of user object for null failed.");
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(int addressId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(addressId);
            return addressRepository.findById(addressId);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation Failed.");
        }
    }

    @Override
    public List<Address> getAddressByUserId(int userId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(userId);
            return addressRepository.findByUserId(userId);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation Failed.");
        }
    }

    @Override
    public Address updateAddress(int oldAddressId, Address newAddress) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(oldAddressId);
            ObjectValidator.validateObjectForNull(newAddress);
            ObjectValidator.validateAddressForNull(newAddress);
            Optional<Address> addressToUpdate = getAddressById(oldAddressId);
            if (addressToUpdate.isPresent()) {
                newAddress.setId(oldAddressId);
                return addressRepository.save(newAddress);
            } else {
                throw new ServiceException("Unable to update address with ID: " + oldAddressId + ". Address is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation Failed.");
        }
    }

    @Override
    public void deleteAddress(int addressId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(addressId);
            Optional<Address> addressToDelete = getAddressById(addressId);
            if (addressToDelete.isPresent()) {
                addressRepository.delete(addressToDelete.get());
            } else {
                throw new ServiceException("Unable to delete address with ID: " + addressId + ". Address is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
        }
    }
}
