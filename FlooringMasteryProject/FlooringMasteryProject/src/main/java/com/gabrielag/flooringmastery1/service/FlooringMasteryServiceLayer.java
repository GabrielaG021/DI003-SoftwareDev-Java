package com.gabrielag.flooringmastery1.service;

import com.gabrielag.flooringmastery1.dao.FlooringMasteryPersistenceException;
import com.gabrielag.flooringmastery1.dto.Order;

import java.time.LocalDate;
import java.util.List;

public interface FlooringMasteryServiceLayer {
    Order addNewOrder(Order order) throws FlooringMasteryPersistenceException;

    Order editOrder(Order upgradeOrder) throws FlooringMasteryPersistenceException, InvalidOrderNumberException;

    Order removeOrder(Order deletedOrder) throws FlooringMasteryPersistenceException, InvalidOrderNumberException;

    Order checkOrders(Order storedOrder, Order editedOrder) throws FlooringMasteryPersistenceException, TaxDataValidationException, ProductDataValidationException;

    List<Order> getTheOrders(LocalDate dateChoice) throws FlooringMasteryPersistenceException, InvalidOrderNumberException;

    Order getAnOrder(int orderNum, LocalDate dateChoice) throws FlooringMasteryPersistenceException, InvalidOrderNumberException;

    Order calculationOfOrder(Order order) throws FlooringMasteryPersistenceException, OrderDataValidationException, TaxDataValidationException, ProductDataValidationException;
}
