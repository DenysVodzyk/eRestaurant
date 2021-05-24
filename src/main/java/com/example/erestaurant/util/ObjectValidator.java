package com.example.erestaurant.util;

import com.example.erestaurant.entity.Address;
import com.example.erestaurant.entity.User;
import com.example.erestaurant.exception.ObjectValidationException;

public class ObjectValidator {

    public static void validateObjectForNull(Object obj) throws ObjectValidationException {
        if (obj == null) {
            throw new ObjectValidationException(obj + " is null");
        }
    }

    public static void validateAddressForNull(Address address) throws ObjectValidationException {
        if (address.getCity() == null ||
                address.getPostalCode() == null ||
                address.getProvince() == null ||
                address.getStreet() == null) {
            throw new ObjectValidationException(address + " object contains null field.");
        }
    }

    public static void validateUserFieldsForNull(User user) throws ObjectValidationException {
        if (user.getName() == null ||
                user.getLastName() == null ||
                user.getRole() == null ||
                user.getEmail() == null ||
                user.getPhoneNumber() == null) {
            throw new ObjectValidationException(user + " object contains null field.");
        }
    }


}
