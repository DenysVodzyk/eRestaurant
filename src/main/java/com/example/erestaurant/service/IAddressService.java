package com.example.erestaurant.service;

import com.example.erestaurant.entity.Address;
import com.example.erestaurant.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface IAddressService {

    void add(Address address) throws ServiceException;

    List<Address> getAllAddresses();

    Optional<Address> getAddressById(int addressId) throws ServiceException;

    List<Address> getAddressByUserId(int userId) throws ServiceException;

    Address updateAddress(int oldAddressId, Address newAddress) throws ServiceException;

    void deleteAddress(int addressId) throws ServiceException;
}
