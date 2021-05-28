package com.example.erestaurant.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payment_card")
public class PaymentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(name = "customer_full_name")
    private String customerFullName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cvc_code")
    private int cvcCode;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

}


