package com.example.erestaurant.repository;

import com.example.erestaurant.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    Optional<CustomerOrder> findById(int id);

    List<CustomerOrder> findByUserId(int userId);

}
