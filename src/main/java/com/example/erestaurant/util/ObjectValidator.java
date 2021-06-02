package com.example.erestaurant.util;

import com.example.erestaurant.entity.*;
import com.example.erestaurant.exception.ObjectValidationException;

public class ObjectValidator {

    public static void validateObjectForNull(Object obj) throws ObjectValidationException {
        if (obj == null) {
            throw new ObjectValidationException(obj + " is null");
        }
    }

    public static void validateAddressFieldsForNull(Address address) throws ObjectValidationException {
        if (address.getAddressLine1() == null ||
                address.getCity() == null ||
                address.getPostalCode() == null ||
                address.getProvince() == null) {
            throw new ObjectValidationException(address + " object contains null field.");
        }
    }

    public static void validatePaymentCardFieldsForNull(PaymentCard paymentCard) throws ObjectValidationException {
        if (paymentCard.getCustomerFullName() == null ||
                paymentCard.getCardNumber() == null ||
                paymentCard.getCvcCode() == 0 ||
                paymentCard.getExpirationDate() == null) {
            throw new ObjectValidationException(paymentCard + " object contains null field.");
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

    public static void validateMenuItemCategoryFieldsForNull(MenuItemCategory menuItemCategory) throws ObjectValidationException {
        if (menuItemCategory.getName() == null) {
            throw new ObjectValidationException(menuItemCategory + " object contains null field.");
        }
    }

    public static void validateMenuItemFieldsForNull(MenuItem menuItem) throws ObjectValidationException {
        if (menuItem.getIngredients() == null || menuItem.getPrice() == 0) {
            throw new ObjectValidationException(menuItem + " object contains null field.");
        }
    }

    public static void validateCustomerOrderFieldsForNull(CustomerOrder customerOrder) throws ObjectValidationException {
        if (customerOrder.getUser() == null || customerOrder.getDishes() == null) {
            throw new ObjectValidationException(customerOrder + " object contains null field.");
        }
    }


}
