package com.gabrielag.flooringmastery1.ui;

import com.gabrielag.flooringmastery1.dto.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 *
 * @author Gabriela Gutierrez
 */

public class FlooringMasteryView {
    private UserIO io;

    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }

    // Method to display the menu for user
//    public int printMenuAndGetSelection() {
//        io.print(" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
//        io.print("*");
//        io.print(" * <<Flooring Program>>");
//        io.print(" * 1. Display Orders");
//        io.print(" * 2. Add an Order");
//        io.print(" * 3. Edit an Order");
//        io.print(" * 4. Remove an Order");
////        io.print(" * 5. Export All Data");
//        io.print(" * 5. Exit");
//        io.print(" *");
//        io.print(" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
//        io.print("*");
//
//        return io.readInt("Please select from the above choices.", 1, 5);
//    }

    // Method to get order number from user
//    public int getOrderNumberFromUser() { return io.readInt("Please enter order number: "); }

//    public LocalDate inputDate() {
//        return io.readDate("Please enter a date. (MM-DD-YYYY)",
//                LocalDate.of(2005, 1, 1), LocalDate.of(2050, 1, 31));
//    }
//    public BigDecimal inputArea() {
//        return io.readBigDecimal("Please enter the area", 2, BigDecimal.ZERO);
//    }
//    // Method to display orders banner
////    public void displayOrdersBanner() {
////        io.print("<<<< DISPLAY ORDERS >>>>");
////    }

    // Method that displays a list of orders and its details for every single order
//    public void displayOrders(List<Order> ordersByDate) {
//        for(Order order : ordersByDate) {
//            displayOrder(order);
//        }
//    }
    // Method to get a specific order
//    public Order getOrder() {
//        Order order = new Order();
//        LocalDate date = null;
//        boolean validateOrderDate = false;
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//        while(!validateOrderDate) {
//            String askDateByUser = io.readString("Please enter a date in format MM-DD-YYYY: ");
//            try {
//                date = LocalDate.parse(askDateByUser, format);
//                validateOrderDate = true;
//            } catch (DateTimeParseException err) {
//                io.print("Invalid user input. The entered date is not a valid date.");
//            }
//        }
//        order.setOrderDate(date);
//        order.setCustomerName(io.readString("Please enter customer's name."));
//        order.setState(io.readString("Please enter state's name."));
//        order.setProductType(io.readString("Please enter the product type needed."));
//        order.setArea(inputArea());
//        return order;
//    }
    /*
     * THE FOLLOWING 3 METHODS BELONG TO THE ADD ORDER CHOICE
     */
    // Method to display the order information
//    public void displayOrder(Order order) {
//        io.print("Order Date: " + order.getOrderDate());
//        io.print("Customer Name: " + order.getCustomerName());
//        io.print("State Name: " + order.getStateAbbr());
//        io.print("Tax Rate: " + order.getTaxRate());
//        io.print("Product Type: " + order.getProductType());
//        io.print("Material Cost: $" + order.getMaterialCost().setScale(2) + " per sq ft");
//        io.print("Labor Cost: $" + order.getLaborCostPerSquareFoot().setScale(2) + " per sq ft");
//        io.print("Area: " + order.getArea() + " per sq ft");
//        io.print("Material Cost Total: " + order.getMaterialCost().setScale(2));
//        io.print("Labor Cost Total: $" + order.getLaborCost().setScale(2));
//        io.print("Tax: $" + order.getTax());
//        io.print("<<<< TOTAL: $" + order.getTotal().setScale(2) + " >>>>");
//    }
    // Method to ask the user to confirm if order information given is to be added or not
//    public String askAddApproval() {
//        return io.readString("Please confirm if you would like to add order? (Y/N)");
//    }
    // Method to display if add action was successful
//    public void displayAddOrderComplete(boolean complete, Order order) {
//        if (complete != true) {
//            io.print("Oops! Order added was unsuccessful.");
//            displayContinueMessage();
//        } else {
//            io.print("Order number - " + order.getOrderNumber() + " - has been successfully added.");
//        }
//    }

    /*
     * THE FOLLOWING 3 METHODS BELONG TO THE EDIT ORDER CHOICE
     */
    // Method to display edit order banner
//    public void displayEditOrderBanner() { io.print("<<<< EDIT ORDER >>>>"); }
    // Method to get new information to save into specific order
//    public Order editOrder(Order order) {
//        Order editOrder = new Order();
//
//        io.print("Customer Name: " + order.getCustomerName());
//        editOrder.setCustomerName(io.readString("Enter the new customer's name (First and Last Name): "));
//
//        io.print("State Name: " + order.getState());
//        editOrder.setState(io.readString("Enter the new state name: "));
//
//        io.print("Product Type: " + order.getProductType());
//        editOrder.setProductType(io.readString("Enter the new product type: "));
//
//        io.print("Area: " + order.getArea() + " square foot");
//        BigDecimal newArea = null;
//        boolean validateAreaInput = false;
//        String areaUserInput;
//        while (!validateAreaInput) {
//            areaUserInput = io.readString("Enter the new area: ");
//            try {
//                newArea = new BigDecimal(areaUserInput).setScale(2, RoundingMode.HALF_UP);
//                validateAreaInput = true;
//            } catch (NumberFormatException err) {
//                io.print("Invalid user input. Please enter a valid area number");
//            }
//        }
//        editOrder.setArea(newArea);
//
//        return editOrder;
//    }
    //Method to display if edit action was successful
//    public void displayEditOrderComplete(boolean complete, Order order) {
//        if (complete != true) {
//            io.print("Oops! Order edited was unsuccessful.");
//            displayContinueMessage();
//        } else {
//            io.print("Order number - " + order.getOrderNumber() + " - has been successfully edited.");
//        }
//    }


    /*
    * THE FOLLOWING 3 METHODS BELONG TO THE REMOVE ORDER CHOICE
    */
    // Method to display remove order banner
//    public void displayRemoveOrderBanner() { io.print("<<<< REMOVE ORDER >>>>"); }
//    // Method to ask the user to confirm if order number given is to be removed or not
//    public String askRemoveApproval() {
//        return io.readString("Please confirm if you would like to remove order? (Y/N): ");
//    }
    // Method to display if remove action was successful
//    public void displayRemoveOrderComplete(boolean complete, Order order) {
//        if (complete != true) {
//            io.print("Oops! Order removed was unsuccessful.");
//            displayContinueMessage();
//        } else {
//            io.print("Order number - " + order.getOrderNumber() + " - has been successfully removed.");
//        }
//    }


    //Method to display the error message and its banner
//    public void displayErrorMessage(String errMessage) {
//        io.print("<<<< ERROR! >>>>");
//        io.print(errMessage);
//        displayContinueMessage();
//    }

    // Method to display the exit message
//    public void displayExitBanner() { io.print("GOOD BYE! HOPE TO SEE YOU AGAIN SOON"); }
//
//    //Method to display unknown command message and its banner
//    public void displayUnknownCommandBanner() { io.print("Unknown Command!!!"); }
//
//    // Method to display instructions on how to continue
//    public void displayContinueMessage() { io.readString("Please hit enter to continue with program."); }
}
