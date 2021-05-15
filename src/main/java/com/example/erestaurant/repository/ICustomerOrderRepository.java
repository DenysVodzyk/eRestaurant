package com.example.erestaurant.repository;

import com.example.erestaurant.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
}
