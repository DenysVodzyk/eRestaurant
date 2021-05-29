package com.example.erestaurant.repository;

import com.example.erestaurant.entity.PaymentCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPaymentCardRepository extends JpaRepository<PaymentCard, Integer> {

    PaymentCard findByCustomerFullNameAndAndCardNumber(String customerFullName, String cardNumber);

    Optional<PaymentCard> findById(int id);

    List<PaymentCard> findByUserId(int id);

}
