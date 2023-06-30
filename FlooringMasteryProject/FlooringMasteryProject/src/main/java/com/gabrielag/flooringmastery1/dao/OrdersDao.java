package com.gabrielag.flooringmastery1.dao;

import com.gabrielag.flooringmastery1.dto.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrdersDao {
    Order addNewOrder(Order order) throws FlooringMasteryPersistenceException;
    Order editAnOrder(Order editAnOrder) throws FlooringMasteryPersistenceException;
    Order removeAnOrder(Order order) throws FlooringMasteryPersistenceException;
    List<Order> getOrders(LocalDate userDateChoice) throws FlooringMasteryPersistenceException;
}
