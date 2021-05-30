package com.example.erestaurant.service;

import com.example.erestaurant.entity.PaymentCard;
import com.example.erestaurant.exception.ObjectValidationException;
import com.example.erestaurant.exception.ServiceException;
import com.example.erestaurant.repository.IPaymentCardRepository;
import com.example.erestaurant.util.ObjectValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PaymentCardService implements IPaymentCardService {
    private IPaymentCardRepository paymentCardRepository;

    @Autowired
    public PaymentCardService(IPaymentCardRepository paymentCardRepository) {
        this.paymentCardRepository = paymentCardRepository;
    }

    @Override
    public void add(PaymentCard paymentCard) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(paymentCard);
            ObjectValidator.validatePaymentCardFieldsForNull(paymentCard);
            ObjectValidator.validateObjectForNull(paymentCard.getUser());
            ObjectValidator.validateUserFieldsForNull(paymentCard.getUser());

            if (paymentCardRepository.findByUserAndCardNumber(paymentCard.getUser(), paymentCard.getCardNumber()) == null) {
                paymentCardRepository.save(paymentCard);
            } else {
                throw new ServiceException("Unable to add payment card: " + paymentCard.getCardNumber() + " for user with id: " + paymentCard.getUser().getId() + ". Payment card already exists.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public List<PaymentCard> getAllPaymentCards() {
        return paymentCardRepository.findAll();
    }

    @Override
    public Optional<PaymentCard> getPaymentCardById(int cardId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(cardId);
            return paymentCardRepository.findById(cardId);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public List<PaymentCard> getPaymentCardByUserId(int userId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(userId);
            return paymentCardRepository.findByUserId(userId);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public void deletePaymentCard(int cardId) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(cardId);
            Optional<PaymentCard> cardToDelete = getPaymentCardById(cardId);
            if (cardToDelete.isPresent()) {
                paymentCardRepository.delete(cardToDelete.get());
            } else {
                throw new ServiceException("Unable to delete payment card with ID: " + cardId + ". Payment card is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }
}
