package com.gabrielag.flooringmastery1.dao;

import com.gabrielag.flooringmastery1.dto.Order;
import com.gabrielag.flooringmastery1.dto.Tax;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdersDaoFileImpl implements OrdersDao {
    List<Order> orders = new ArrayList<>();
    public static final String DELIMITER = ",";
    public static String ORDER_FILE = "FlooringMasteryProject/FlooringMasteryProject/Orders";
    private static final String FILEHEADER = "OrderNumber,CustomerName,State,TaxRate,"
            + "ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,"
            + "MaterialCost,LaborCost,Tax,Total";
    int storedLastOrderNum;
    @Override
    public Order addNewOrder(Order order) throws FlooringMasteryPersistenceException {
        // load the last order number saved
        loadTheLastOrderNumber();
        // Add one to last order number
        storedLastOrderNum++;
        // Save new order number
        order.setOrderNumber(storedLastOrderNum);
        // Write new order number to store in file
        writeTheLastOrderNumber(storedLastOrderNum);
        // Loads a list of orders for a specific order date. It returns a List<Order> containing the orders.
        List<Order> orders = loadTheOrders(order.getOrderDate());
        // adds the new order to the existing list of orders for the given order date.
        orders.add(order);
        // write the updated list of orders back to the storage, presumably to persist the changes.
        writeTheOrders(orders, order.getOrderDate());
        return order;
    }

    @Override
    public Order editAnOrder(Order editAnOrder) throws FlooringMasteryPersistenceException {
        int orderNum = editAnOrder.getOrderNumber();

        try {
            List<Order> orders = loadTheOrders(editAnOrder.getOrderDate());

            // Lambda Expression
            // orders.stream() = call "orders" list to convert to stream of "Order" objects
            // filter() = filter the stream of objects and find the order with a matching order number
            // findFirst() = retrieves first order that matches the filter, if not found, null is returned
            Order orderChoices = orders.stream().filter(order -> order.getOrderNumber() == orderNum).findFirst().orElse(null);
            if(orderChoices != null) {
                int i = orders.indexOf(orderChoices);
                orders.set(i, editAnOrder);
                writeTheOrders(orders, editAnOrder.getOrderDate());
                return editAnOrder;
            } else { return null; }
        } catch (FlooringMasteryPersistenceException err) {
            throw new FlooringMasteryPersistenceException("Error occurred while editing the specified order: ", err);
        }
    }

    @Override
    public Order removeAnOrder(Order orderChoice) throws FlooringMasteryPersistenceException {
        int orderNum = orderChoice.getOrderNumber();

        List<Order> orders = loadTheOrders(orderChoice.getOrderDate());
        Order removeOrderChoice = orders.stream().filter(order -> order.getOrderNumber() == orderNum).findFirst().orElse(null);

        if (removeOrderChoice != null) {
            orders.remove(removeOrderChoice);
            writeTheOrders(orders, orderChoice.getOrderDate());
            return removeOrderChoice;
        } else { return null; }
    }

    @Override
    public List<Order> getOrders(LocalDate userDateChoice) throws FlooringMasteryPersistenceException {
        return loadTheOrders(userDateChoice);
    }

    /*
    * The following two functions are going to load orders from file and then,
    * write (save) orders to the file.
    * */
    public List<Order> loadTheOrders(LocalDate orderDate) throws FlooringMasteryPersistenceException {
        Scanner scanner;
        String fileDateFormat = userGivenDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        File file = new File(String.format(ORDER_FILE + "Orders_" + orderDate + ".txt"));

        if (file.isFile()) {
            try {
                // Process the order file
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                scanner = new Scanner(bufferedReader);
            } catch (FileNotFoundException err) {
                throw new FlooringMasteryPersistenceException("Could not load orders.", err);
            }
            // currentLine holds the most recent line read from the file
            String currentLine;
            Order currentOrder;
            while(scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentOrder = unmarshallOrder(orderDate, currentLine);
                orders.add(currentOrder);
            }

            scanner.close();
            return orders;
        } else {
            return orders;
        }
    }
    public void writeTheOrders(List<Order> orders, LocalDate orderDate) throws FlooringMasteryPersistenceException {
        PrintWriter out;
        //String fileDateFormat = userGivenDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        File file = new File(String.format(ORDER_FILE + "Orders_" + orderDate + ".txt"));

        try {
            FileWriter fileWriter = new FileWriter(file);
            out = new PrintWriter(fileWriter);
        } catch (IOException err) {
            throw new FlooringMasteryPersistenceException("Could not write the order data into .txt file", err);
        }
        out.println(FILEHEADER);
        String newOrderEntry;
        for (Order currentOrder : orders) {
            // turn an Order into a String
            newOrderEntry = marshallOrder(currentOrder);
            // write the Order object to the file
            out.println(newOrderEntry);
            // force PrintWriter to write line to the file
            out.flush();
        }
        out.close();
    }
    private String marshallOrder(Order currentOrder) {
        return null;
    }


    /*
    * The following two functions are going to load from a file and write to a file
    *  the last order number that was used to prevent overrides from happening.
    */
    private void loadTheLastOrderNumber() throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try {
            FileReader fileReader = new FileReader("storeOrderNumbers.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            scanner = new Scanner(bufferedReader);
        } catch (FileNotFoundException err) {
            throw new FlooringMasteryPersistenceException("Could not load the last order number from .txt file.", err);
        }

        int storedOrderNum = Integer.parseInt(scanner.nextLine());
        this.storedLastOrderNum = storedOrderNum;

        scanner.close();
    }
    private void writeTheLastOrderNumber(int storedLastOrderNum) throws FlooringMasteryPersistenceException {
        PrintWriter out;

        try {
            FileWriter fileWriter = new FileWriter("storeOrderNumbers.txt");
            out = new PrintWriter(fileWriter);
        } catch (IOException err) {
            throw new FlooringMasteryPersistenceException("Could not write the last order number into .txt file", err);
        }

        out.println(storedLastOrderNum);
        out.flush();
        out.close();
    }

    public Order unmarshallOrder(String orderAsText) {
//        String fileDateFormat = orderDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        String[] orderTokens = orderAsText.split(DELIMITER);
        int orderNumber = Integer.parseInt(orderTokens[0]);
        String customerName = orderTokens[1];
        String stateAbbr = orderTokens[2];
        BigDecimal taxRate = new BigDecimal(orderTokens[3]);
        String productType = orderTokens[4];
        BigDecimal area = new BigDecimal(orderTokens[5]);
        BigDecimal costPerSquareFoot = new BigDecimal(orderTokens[6]);
        BigDecimal laborCostPerSquareFoot = new BigDecimal(orderTokens[7]);
        BigDecimal materialCost = new BigDecimal(orderTokens[8]);
        BigDecimal laborCost = new BigDecimal(orderTokens[9]);
        BigDecimal tax = new BigDecimal(orderTokens[10]);
        BigDecimal total = new BigDecimal(orderTokens[11]);

        Order newOrderInFile = new Order();
        Tax getTax = new Tax();
        newOrderInFile.setOrderDate(LocalDate.parse(fileDateFormat));
        newOrderInFile.setOrderNumber(orderNumber);
        newOrderInFile.setCustomerName(customerName);
        getTax.setStateAbbr(stateAbbr);
        newOrderInFile.setTaxRate(taxRate);
        newOrderInFile.setProductType(productType);
        newOrderInFile.setArea(area);
        newOrderInFile.setCostPerSquareFoot(costPerSquareFoot);
        newOrderInFile.setLaborCostPerSquareFoot(laborCostPerSquareFoot);
        newOrderInFile.setMaterialCost(materialCost);
        newOrderInFile.setLaborCost(laborCost);
        newOrderInFile.setTax(tax);
        newOrderInFile.setTotal(total);

        return newOrderInFile;
    }
    public String marshallOrder(Order order, Tax tax) {
        String oneOrder = order.getOrderNumber() + DELIMITER;
        oneOrder += order.getCustomerName() + DELIMITER;
        oneOrder += order.getStateAbbr() + DELIMITER;
        oneOrder += order.getTaxRate() + DELIMITER;
        oneOrder += order.getProductType() + DELIMITER;
        oneOrder += order.getArea() + DELIMITER;
        oneOrder += order.getCostPerSquareFoot() + DELIMITER;
        oneOrder += order.getLaborCostPerSquareFoot() + DELIMITER;
        oneOrder += order.getMaterialCost() + DELIMITER;
        oneOrder += order.getLaborCost() + DELIMITER;
        oneOrder += order.getTax() + DELIMITER;
        oneOrder += order.getTotal();

        return oneOrder;
    }

}
