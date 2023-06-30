package com.gabrielag.flooringmastery1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Gabriela Gutierrez
 */

public class Order {
    private int orderNumber;
    private LocalDate orderDate;
    private String customerName;
    private String state;
    //    private String stateAbbr;
    private BigDecimal taxRate;
    private String productType;
    private BigDecimal area;
    private BigDecimal costPerSquareFoot;
    private BigDecimal laborCostPerSquareFoot;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;

    // ALL GETTER METHODS
    public int getOrderNumber() {
        return orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getState() {
        return state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal getTotal() {
        return total;
    }


    // ALL SETTER METHODS
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        if (this.orderNumber != order.orderNumber) return false;
        if (!Objects.equals(this.orderDate, order.orderDate)) return false;
        if (!Objects.equals(this.state, order.state)) return false;
        if (!Objects.equals(this.productType, order.productType)) return false;
        if (!Objects.equals(this.area, order.area)) return false;
        if (!Objects.equals(this.costPerSquareFoot, order.costPerSquareFoot)) return false;
        if (!Objects.equals(this.laborCostPerSquareFoot, order.laborCostPerSquareFoot)) return false;
        if (!Objects.equals(this.materialCost, order.materialCost)) return false;
        if (!Objects.equals(this.laborCost, order.laborCost)) return false;
        if (!Objects.equals(this.tax, order.tax)) return false;
        if (!Objects.equals(this.total, order.total)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.orderNumber;
        hash = 47 * hash + Objects.hashCode(this.orderDate);
        hash = 47 * hash + Objects.hashCode(this.customerName);
        hash = 47 * hash + Objects.hashCode(this.state);
        hash = 47 * hash + Objects.hashCode(this.taxRate);
        hash = 47 * hash + Objects.hashCode(this.productType);
        hash = 47 * hash + Objects.hashCode(this.area);
        hash = 47 * hash + Objects.hashCode(this.costPerSquareFoot);
        hash = 47 * hash + Objects.hashCode(this.laborCostPerSquareFoot);
        hash = 47 * hash + Objects.hashCode(this.materialCost);
        hash = 47 * hash + Objects.hashCode(this.laborCost);
        hash = 47 * hash + Objects.hashCode(this.tax);
        hash = 47 * hash + Objects.hashCode(this.total);
        return hash;
    }
}
