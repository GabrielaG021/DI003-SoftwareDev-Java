package com.gabrielag.flooringmastery1;

/**
 *
 * @author Gabriela Gutierrez
 */

import com.gabrielag.flooringmastery1.controller.FlooringMasteryController;
import com.gabrielag.flooringmastery1.dao.*;
import com.gabrielag.flooringmastery1.dto.Order;
import com.gabrielag.flooringmastery1.ui.FlooringMasteryView;
import com.gabrielag.flooringmastery1.ui.UserIO;
import com.gabrielag.flooringmastery1.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        UserIO myIO = new UserIOConsoleImpl();
//        // Instantiate the View and wire the UserIO implementation into it
//        FlooringMasteryView myView = new FlooringMasteryView(myIO);
//        // Instantiate the DAO
//        OrdersDao myOrdersDao = new OrdersDaoFileImpl();
//        ProductsDao myProductsDao = new ProductsDaoFileImpl();
//        TaxDao myTaxDao = new TaxDaoFileImpl();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        FlooringMasteryController controller = applicationContext.getBean("controller", FlooringMasteryController.class);
        controller.run();
    }
}
