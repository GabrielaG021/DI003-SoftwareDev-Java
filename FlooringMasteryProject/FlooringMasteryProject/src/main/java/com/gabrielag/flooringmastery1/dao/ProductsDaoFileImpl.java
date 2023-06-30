package com.gabrielag.flooringmastery1.dao;

import com.gabrielag.flooringmastery1.dto.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsDaoFileImpl implements ProductsDao {
    private static final String DELIMITER = ",";
    private static final String PRODUCTS_FILE = "FlooringMasteryProject/FlooringMasteryProject/Products.txt";
    List<Product> products = new ArrayList<>();

    @Override
    public Product getProduct(String productType) throws FlooringMasteryPersistenceException {
        List<Product> products = loadTheProducts();
        if (products != null) {
            // Find the product with the matching product type from the list of products
            Product productChosen = products.stream()
                    .filter(product -> product.getProductType().equalsIgnoreCase(productType)) // Filter products based on product type (case-insensitive)
                    .findFirst() // Retrieve the first matching product, or null if no match is found
                    .orElse(null); // If no matching product is found, assign null to productChosen
            return productChosen;
        } else {
            return null;
        }
    }
    private List<Product> loadTheProducts() throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try{
            FileReader fileReader = new FileReader(PRODUCTS_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            scanner = new Scanner(bufferedReader);
        } catch (FileNotFoundException err) {
            throw new FlooringMasteryPersistenceException("Could not load the products data.", err);
        }
        // currentLine holds the most recent line read from the file

        scanner.close();

        if(products.isEmpty()) {
            return null;
        } else {
            return products;
        }
    }

    public Product unmarshallProduct(String productAsText) {
        String[] productTokens = productAsText.split(DELIMITER);
        String productType = productTokens[0];
        BigDecimal costPerSquareFoot = new BigDecimal(productTokens[1]).setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborCostPerSquareFoot = new BigDecimal(productTokens[2]).setScale(2, RoundingMode.HALF_UP);

        Product productOutFile = new Product();
        productOutFile.setProductType(productType);
        productOutFile.setCostPerSquareFoot(costPerSquareFoot);
        productOutFile.setLaborCostPerSquareFoot(laborCostPerSquareFoot);

        return productOutFile;
    }
    public String marshallProduct(Product aproduct) {
        String productAsText = aproduct.getProductType() + DELIMITER;
        productAsText += aproduct.getCostPerSquareFoot() + DELIMITER;
        productAsText += aproduct.getLaborCostPerSquareFoot();

        return productAsText;
    }
}
