package com.example.erestaurant.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment_card")
public class PaymentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "customer_full_name")
    private String customerFullName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cvc_code")
    private int cvcCode;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    public PaymentCard() {
    }

    public PaymentCard(String customerFullName, String cardNumber, int cvcCode, LocalDate expirationDate) {
        this.customerFullName = customerFullName;
        this.cardNumber = cardNumber;
        this.cvcCode = cvcCode;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(int cvcCode) {
        this.cvcCode = cvcCode;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "PaymentCard{" +
                "id=" + id +
                ", customerFullName='" + customerFullName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvcCode=" + cvcCode +
                ", expirationDate=" + expirationDate +
                '}';
    }
}


