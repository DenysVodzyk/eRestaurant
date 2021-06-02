package com.example.erestaurant.service;

import com.example.erestaurant.entity.CustomerOrder;
import com.example.erestaurant.entity.Dish;
import com.example.erestaurant.entity.OrderStatus;
import com.example.erestaurant.exception.ObjectValidationException;
import com.example.erestaurant.exception.ServiceException;
import com.example.erestaurant.repository.ICustomerOrderRepository;
import com.example.erestaurant.util.ObjectValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerOrderService implements ICustomerOrderService {
    private ICustomerOrderRepository customerOrderRepository;

    @Autowired
    public CustomerOrderService(ICustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }


    @Override
    public Optional<CustomerOrder> getById(int id) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(id);
            return customerOrderRepository.findById(id);
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }

    @Override
    public void addOrder(CustomerOrder order) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(order);
            ObjectValidator.validateCustomerOrderFieldsForNull(order);
            order.setStatus(OrderStatus.RECEIVED);
            order.setOrderSubmitTime(LocalDateTime.now());
            order.setTotalPrice(getTotalPriceOfOrder(order));
            customerOrderRepository.save(order);
            //finish dishService.add that accepts order

        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }

    }

    @Override
    public List<CustomerOrder> getAll() {
        return customerOrderRepository.findAll();
    }

    @Override
    public int getTotalPriceOfOrder(CustomerOrder order) {
        int totalPrice = 0;
        List<Dish> dishes = order.getDishes();
        for (Dish dish : dishes) {
            totalPrice += dish.getMenuItem().getPrice() * dish.getQuantity();
        }
        return totalPrice;
    }

    @Override
    public List<CustomerOrder> getByUserId(int userId) {
        return null;
    }

    @Override
    public void pushOrderStatus(int orderId, OrderStatus newOrderStatus) throws ServiceException {
        try {
            ObjectValidator.validateObjectForNull(orderId);
            ObjectValidator.validateObjectForNull(newOrderStatus);
            Optional<CustomerOrder> order = getById(orderId);
            if (order.isPresent()) {
                order.get().setStatus(newOrderStatus);
                customerOrderRepository.save(order.get());
            } else {
                throw new ServiceException("Unable to update customer order with ID: " + orderId + ". Customer order is not registered in the database.");
            }
        } catch (ObjectValidationException e) {
            e.printStackTrace();
            throw new ServiceException("Validation for null failed.");
        }
    }
}
