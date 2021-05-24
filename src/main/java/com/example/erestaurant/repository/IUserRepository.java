package com.example.erestaurant.repository;

import com.example.erestaurant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByNameAndLastName(String name, String lastName);

    User findByIdAndPassword(int id, String password);

}



