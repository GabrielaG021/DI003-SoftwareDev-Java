package com.gabrielag.flooringmastery1.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Tax {
    private String stateAbbr;
    private String stateName;
    private BigDecimal taxRate;

    // ALL GETTER METHODS
    public String getStateAbbr() {
        return stateAbbr;
    }

    public String getStateName() {
        return stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }


    // ALL SETTER METHODS
    public void setStateAbbr(String stateAbbr) { this.stateAbbr = stateAbbr; }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.stateAbbr);
        hash = 37 * hash + Objects.hashCode(this.stateName);
        hash = 37 * hash + Objects.hashCode(this.taxRate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Tax tax = (Tax) obj;
        if (!Objects.equals(this.stateAbbr, tax.stateAbbr)) return false;
        if (!Objects.equals(this.stateName, tax.stateName)) return false;
        if (!Objects.equals(this.taxRate, tax.taxRate)) return false;

        return true;
    }
}
