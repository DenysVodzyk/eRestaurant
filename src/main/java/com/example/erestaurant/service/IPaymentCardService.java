package com.example.erestaurant.service;

import com.example.erestaurant.entity.PaymentCard;
import com.example.erestaurant.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface IPaymentCardService {
    void add(PaymentCard paymentCard) throws ServiceException;

    List<PaymentCard> getAllPaymentCards();

    PaymentCard getPaymentCardByCustomerFullNameAndAndCardNumber(String customerFullName, String cardNumber);

    Optional<PaymentCard> getPaymentCardById(int addressId) throws ServiceException;

    List<PaymentCard> getPaymentCardByUserId(int userId) throws ServiceException;

    void deletePaymentCard(int cardId) throws ServiceException;

}
