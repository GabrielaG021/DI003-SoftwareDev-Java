/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gabrielag.scratchpaper;

/**
 *
 * @author Gabriela Gutierrez
 */
public class AppHelloWorld {

    public static void main(String[] args) {
        HelloWorld obj1 = new HelloWorld();
        obj1.Display();
        Display2();
        
        // Classes don't need to be in the same package
        // Import statement will help locate it
        
        HelloWorld.Display3();
    }
    
    static void Display2(){
        System.out.println("Method within the user class");
    }
}
