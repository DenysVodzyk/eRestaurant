package com.example.erestaurant.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "address-user")
    private List<Address> addresses;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "payment-user")
    private List<PaymentCard> paymentCards;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "order-user")
    private List<CustomerOrder> orders;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_anonymous")
    @JsonProperty("isAnonymous")
    private boolean isAnonymous;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private LocalDate dOb;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_active")
    @JsonProperty("isActive")
    private boolean isActive;

}
