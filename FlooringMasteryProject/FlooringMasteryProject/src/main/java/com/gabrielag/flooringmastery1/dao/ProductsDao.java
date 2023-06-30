package com.gabrielag.flooringmastery1.dao;

import com.gabrielag.flooringmastery1.dto.Product;

public interface ProductsDao {
    Product getProduct(String productType) throws FlooringMasteryPersistenceException;
}
