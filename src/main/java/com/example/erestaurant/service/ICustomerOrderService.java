package com.example.erestaurant.service;

import com.example.erestaurant.entity.CustomerOrder;
import com.example.erestaurant.entity.OrderStatus;
import com.example.erestaurant.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface ICustomerOrderService {

    Optional<CustomerOrder> getById(int id) throws ServiceException;

    void addOrder(CustomerOrder order) throws ServiceException;

    List<CustomerOrder> getAll();

    int getTotalPriceOfOrder(CustomerOrder order);

    List<CustomerOrder> getByUserId(int userId);

    void pushOrderStatus(int orderId, OrderStatus newOrderStatus) throws ServiceException;

}