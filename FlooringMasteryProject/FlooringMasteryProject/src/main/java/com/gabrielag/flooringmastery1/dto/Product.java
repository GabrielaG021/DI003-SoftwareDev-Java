package com.gabrielag.flooringmastery1.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Product {
    private String productType;
    private BigDecimal costPerSquareFoot;
    private BigDecimal laborCostPerSquareFoot;

    // ALL GETTER METHODS
    public String getProductType() {
        return productType;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }


    // ALL SETTER METHODS
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        final Product product = (Product) obj;
        if(!Objects.equals(this.productType, product.productType)) return false;
        if(!Objects.equals(this.costPerSquareFoot, product.costPerSquareFoot)) return false;
        if(!Objects.equals(this.laborCostPerSquareFoot, product.laborCostPerSquareFoot)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.productType);
        hash = 37 * hash + Objects.hashCode(this.costPerSquareFoot);
        hash = 37 * hash + Objects.hashCode(this.laborCostPerSquareFoot);

        return hash;
    }
}
