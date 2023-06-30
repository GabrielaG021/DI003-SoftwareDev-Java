package com.gabrielag.flooringmastery1.dao;

import com.gabrielag.flooringmastery1.dto.Tax;

public interface TaxDao {
    Tax getTax(String stateAbbr) throws FlooringMasteryPersistenceException;
}
