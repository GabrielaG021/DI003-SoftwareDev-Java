package com.gabrielag.flooringmastery1.controller;

/**
 *
 * @author Gabriela Gutierrez
 */

import com.gabrielag.flooringmastery1.dao.FlooringMasteryPersistenceException;
import com.gabrielag.flooringmastery1.dto.Order;
import com.gabrielag.flooringmastery1.service.*;
import com.gabrielag.flooringmastery1.ui.FlooringMasteryView;
import com.gabrielag.flooringmastery1.ui.UserIO;
import com.gabrielag.flooringmastery1.ui.UserIOConsoleImpl;

import java.time.LocalDate;
import java.util.List;

public class FlooringMasteryController {
    /*
     * Add a member of type FlooringMasteryView and the controller will
     * use it for displaying the menu and getting the user's selection.
     */
    private FlooringMasteryView view;
    private FlooringMasteryServiceLayer service;
    private UserIO io = new UserIOConsoleImpl();

    public FlooringMasteryController(FlooringMasteryServiceLayer service, FlooringMasteryView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while(keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        getOrdersOnFileByDate();
                        break;
                    case 2:
                        addNewOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeAnOrder();
                        break;
//                    case 5:
//                        io.print("EXPORT DATA");
//                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (FlooringMasteryPersistenceException err) {
            view.displayErrorMessage(err.getMessage());
        }
    }

    // Made a call to printlnMenuAndGetSelection() on the view member
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void getOrdersOnFileByDate() throws FlooringMasteryPersistenceException {
        LocalDate dateChosen = view.inputDate();
        view.displayOrdersBanner();

        try {
            view.displayOrders(service.getTheOrders(dateChosen));
            view.displayContinueMessage();
        } catch (InvalidOrderNumberException err) {
            view.displayErrorMessage(err.getMessage());
        }
    }

    private void addNewOrder() throws FlooringMasteryPersistenceException {
        try {
            Order order = service.calculationOfOrder(view.getOrder());
            view.displayOrder(order);
            String userAnswer = view.askAddApproval();
            if (userAnswer.equalsIgnoreCase("Y")) {
                service.addNewOrder(order);
                view.displayAddOrderComplete(true, order);
            } else if (userAnswer.equalsIgnoreCase("N")) {
                view.displayAddOrderComplete(false, order);
            } else {
                unknownCommand();
            }
        } catch (OrderDataValidationException | ProductDataValidationException | TaxDataValidationException err) {
            view.displayErrorMessage(err.getMessage());
        }
    }

    private void editOrder() throws FlooringMasteryPersistenceException {
        try {
            LocalDate dateChosen = view.inputDate();
            int orderNumber = view.getOrderNumberFromUser();
            Order storedOrder = service.getOrder(orderNumber, dateChosen);
            Order editedOrder = view.editOrder(storedOrder);
            Order newInfoOrder = service.checkOrders(storedOrder, editedOrder);
            view.displayEditOrderBanner();
            view.displayOrder(newInfoOrder);
            String answer = view.askAddApproval();

            if(answer.equalsIgnoreCase("Y")) {
                service.editOrder(newInfoOrder);
                view.displayEditOrderComplete(true, newInfoOrder);
            } else if (answer.equalsIgnoreCase("N")) {
                view.displayEditOrderComplete(false, newInfoOrder);
            } else {
                unknownCommand();
            }
        } catch (InvalidOrderNumberException e) {
            throw new RuntimeException(e);
        } catch (TaxDataValidationException e) {
            throw new RuntimeException(e);
        } catch (ProductDataValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private void removeAnOrder() throws FlooringMasteryPersistenceException {
        LocalDate dateChosen = view.inputDate();

        try {
            view.displayOrders(service.getTheOrders(dateChosen));
            int orderNum = view.getOrderNumberFromUser();
            Order order = service.getOrder(orderNum, dateChosen);
            view.displayRemoveOrderBanner();
            view.displayOrder(order);
            String answer = view.askRemoveApproval();
            if (answer.equalsIgnoreCase("Y")){
                service.removeOrder(order);
                view.displayRemoveOrderComplete(true, order);
            } else if (answer.equalsIgnoreCase("N")) {
                view.displayRemoveOrderComplete(false, order);
            } else {
                unknownCommand();
            }
        } catch (InvalidOrderNumberException err) {
            view.displayErrorMessage(err.getMessage());
        }
    }
    private void unknownCommand() { view.displayUnknownCommandBanner(); }
    private void exitMessage() { view.displayExitBanner(); }
}
