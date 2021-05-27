package com.example.erestaurant.repository;

import com.example.erestaurant.entity.Address;
import com.example.erestaurant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAddressRepository extends JpaRepository<Address, Integer> {

    Address findByAddressLine1(String addressLine1);

    Optional<Address> findById(int id);

    List<Address> findByUserId(int id);

    Address findByUserAndAddressLine1(User user, String addressLine1);

}
