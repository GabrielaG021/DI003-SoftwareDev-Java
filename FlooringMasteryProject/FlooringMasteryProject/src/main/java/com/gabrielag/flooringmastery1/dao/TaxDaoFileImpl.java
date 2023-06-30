package com.gabrielag.flooringmastery1.dao;

import com.gabrielag.flooringmastery1.dto.Tax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaxDaoFileImpl implements TaxDao {
    private static final String DELIMITER = ",";
    private static final String TAXES_FILE = "FlooringMasteryProject/FlooringMasteryProject/Taxes.txt";
    List<Tax> taxes = new ArrayList<>();

    // Method to retrieve the tax information for a specific state abbreviation
    @Override
    public Tax getTax(String stateAbbr) throws FlooringMasteryPersistenceException {
        // Load the list of taxes from the data source
        List<Tax> taxes = loadTheTaxes();
        // Check if taxes exist
        if(taxes != null){
            // Find the tax with the matching state abbreviation from the list of taxes
            Tax taxChosen = taxes.stream()
                    .filter(tax -> tax.getStateAbbr().equalsIgnoreCase(stateAbbr)) // Filter taxes based on state abbreviation (case-insensitive)
                    .findFirst()// Retrieve the first matching tax, or null if no match is found
                    .orElse(null);  // If no matching tax is found, assign null to taxChosen
            return taxChosen;
        } else {
            return null;
        }
    }

    private List<Tax> loadTheTaxes() throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try {
            FileReader fileReader = new FileReader(TAXES_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            scanner = new Scanner(bufferedReader);
        } catch (FileNotFoundException err) {
            throw new FlooringMasteryPersistenceException("Could not load the taxes data", err);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        Tax currentTax = new Tax();
        String[] currentTokens;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            if (currentTokens.length == 3) {
                String stateAbbr = currentTokens[0];
                String stateName = currentTokens[1];
                BigDecimal taxRate = new BigDecimal(currentTokens[2]);

                currentTax.setStateAbbr(stateAbbr);
                currentTax.setStateName(stateName);
                currentTax.setTaxRate(taxRate);
            } else {
                // Ignore lines if empty
            }
            taxes.add(currentTax);
        }
        scanner.close();

        if(taxes.isEmpty()) {
            return null;
        } else {
            return taxes;
        }
    }

    public Tax unmarshallTax(String taxAsText){
        String[] taxTokens = taxAsText.split(DELIMITER);
        String stateAbbr = taxTokens[0];
        String stateName = taxTokens[1];
        BigDecimal taxRate = new BigDecimal(taxTokens[2]);

        Tax taxOutFile = new Tax();
        taxOutFile.setStateAbbr(stateAbbr);
        taxOutFile.setStateName(stateName);
        taxOutFile.setTaxRate(taxRate);

        return taxOutFile;
    }

    // Marshall tax data into the txt file
    public String marshallTax(Tax atax) {
        String taxAsText = atax.getStateAbbr() + DELIMITER;
        taxAsText += atax.getStateName() + DELIMITER;
        taxAsText += atax.getTaxRate();

        return taxAsText;
    }
}
