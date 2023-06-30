package com.gabrielag.flooringmastery1.service;

import com.gabrielag.flooringmastery1.dao.*;
import com.gabrielag.flooringmastery1.dto.Order;
import com.gabrielag.flooringmastery1.dto.Product;
import com.gabrielag.flooringmastery1.dto.Tax;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {
    private OrdersDao ordersDao;
    private ProductsDao productsDao;
    private TaxDao taxDao;
    private AuditDao auditDao;

    public FlooringMasteryServiceLayerImpl(OrdersDao ordersDao, ProductsDao productsDao, TaxDao taxDao, AuditDao auditDao) {
        this.ordersDao = ordersDao;
        this.productsDao = productsDao;
        this.taxDao = taxDao;
        this.auditDao = auditDao;
    }
    @Override
    public Order addNewOrder(Order order) throws FlooringMasteryPersistenceException {
        ordersDao.addNewOrder(order);
        auditDao.writeAuditEntry("Order Number: " + order.getOrderNumber() + ", Date: " + order.getOrderDate() + ", ADDED.");

        return order;
    }

    @Override
    public Order editOrder(Order editedOrder) throws FlooringMasteryPersistenceException, InvalidOrderNumberException {
        editedOrder = ordersDao.editAnOrder(editedOrder);
        if (editedOrder == null) {
            throw new InvalidOrderNumberException("No orders found with that order number.");
        } else {
            auditDao.writeAuditEntry("Order number: " + editedOrder.getOrderNumber() + ", Order Date: " + editedOrder.getOrderDate() + ", Status: EDITED");
            return editedOrder;
        }
    }

    @Override
    public Order removeOrder(Order deletedOrder) throws FlooringMasteryPersistenceException, InvalidOrderNumberException {
        deletedOrder = ordersDao.removeAnOrder(deletedOrder);
        if (deletedOrder == null) {
            throw new InvalidOrderNumberException("No orders found with that order number.");
        } else {
            auditDao.writeAuditEntry("Order number: " + deletedOrder.getOrderNumber() + ", Order Date: " + deletedOrder.getOrderDate() + ", Status: REMOVED");
            return deletedOrder;
        }
    }

    @Override
    public Order checkOrders(Order storedOrder, Order editedOrder) throws FlooringMasteryPersistenceException, TaxDataValidationException, ProductDataValidationException {
        if (editedOrder.getCustomerName() == null || editedOrder.getState().trim().equals("")) {
        } else {
            storedOrder.setCustomerName(editedOrder.getCustomerName());
        }

        if (editedOrder.getState() == null || editedOrder.getState().trim().equals("")) {
        } else {
            storedOrder.setProductType(editedOrder.getProductType());
            calculationOfMaterialCost(storedOrder);
        }

        if (editedOrder.getArea() == null || (editedOrder.getArea().compareTo(BigDecimal.ZERO)) == 0) {
        } else {
            storedOrder.setArea(editedOrder.getArea());
        }

        calculationOfTotalOrder(storedOrder);
        return storedOrder;
    }

    @Override
    public List<Order> getTheOrders(LocalDate dateChoice) throws FlooringMasteryPersistenceException, InvalidOrderNumberException {
        List<Order> displayOrdersByDate = ordersDao.getOrders(dateChoice);

        if(displayOrdersByDate.isEmpty()) {
            throw new InvalidOrderNumberException("No orders found for the specified date.");
        } else {
            return displayOrdersByDate;
        }
    }

    @Override
    public Order getOrder(int orderNum, LocalDate dateChoice) throws FlooringMasteryPersistenceException, InvalidOrderNumberException {
        List<Order> orders = getTheOrders(dateChoice);
        Order orderChosen = orders.stream()
                .filter(order -> order.getOrderNumber() == orderNum)
                .findFirst()
                .orElse(null);

        if(orderChosen == null) {
            throw new InvalidOrderNumberException("No orders found with the specified date.");
        } else {
            return orderChosen;
        }
    }

    @Override
    public Order calculationOfOrder(Order order) throws FlooringMasteryPersistenceException, OrderDataValidationException, TaxDataValidationException, ProductDataValidationException {
        orderValidation(order);
        calculationOfTax(order);
        calculationOfMaterialCost(order);
        calculationOfTotalOrder(order);

        return order;
    }
    private void calculationOfTax(Order order) throws FlooringMasteryPersistenceException, TaxDataValidationException {
        Tax stateChosen = taxDao.getTax(order.getState());
        if (stateChosen == null) {
            throw new TaxDataValidationException("Oops! We do not serve to that state just yet.");
        }
        order.setState(stateChosen.getStateAbbr());
        order.setTaxRate(stateChosen.getTaxRate());
    }

    private void calculationOfMaterialCost(Order order) throws FlooringMasteryPersistenceException, ProductDataValidationException {
        Product productChosen = productsDao.getProduct(order.getProductType());
        if(productChosen == null) {
            throw new ProductDataValidationException("Oops! We do not sell this product type just yet.");
        }

        order.setProductType(productChosen.getProductType());
        order.setCostPerSquareFoot(productChosen.getCostPerSquareFoot());
        order.setLaborCostPerSquareFoot(productChosen.getLaborCostPerSquareFoot());
    }

    private void calculationOfTotalOrder(Order order) {
        order.setMaterialCost(order.getCostPerSquareFoot().multiply(order.getArea()).setScale(2, RoundingMode.HALF_UP));
        order.setLaborCost(order.getLaborCostPerSquareFoot().multiply(order.getArea()).setScale(2, RoundingMode.HALF_UP));
        order.setTax(order.getTaxRate().divide(new BigDecimal("100.00")).multiply((order.getMaterialCost().add(order.getLaborCost()))).setScale(2, RoundingMode.HALF_UP));
        order.setTotal(order.getMaterialCost().add(order.getLaborCost()).add(order.getTax()));
    }
    private void orderValidation(Order order) throws OrderDataValidationException {
        String eMessage = "";

        if(order.getCustomerName().trim().isEmpty() || order.getCustomerName() == null) {
            eMessage += "The customer name is required to continue.\n";
        } else if(order.getState().trim().isEmpty() || order.getState() == null) {
            eMessage += "The state name is required to continue.\n";
        } else if(order.getProductType().trim().isEmpty() || order.getProductType() == null) {
            eMessage += "The product type is required to continue.\n";
        } else if(order.getArea().compareTo(BigDecimal.ZERO) == 0 || order.getArea() == null) {
            eMessage += "The area is required to continue.\n";
        } else if(!eMessage.isEmpty()) {
            throw new OrderDataValidationException(eMessage);
        }
    }
}