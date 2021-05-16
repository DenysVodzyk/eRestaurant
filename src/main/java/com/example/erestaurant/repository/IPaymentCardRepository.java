package com.example.erestaurant.repository;

import com.example.erestaurant.entity.PaymentCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentCardRepository extends JpaRepository<PaymentCard, Integer> {
}
