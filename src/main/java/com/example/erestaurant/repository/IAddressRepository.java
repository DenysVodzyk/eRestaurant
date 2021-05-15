package com.example.erestaurant.repository;

import com.example.erestaurant.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Integer> {
}
