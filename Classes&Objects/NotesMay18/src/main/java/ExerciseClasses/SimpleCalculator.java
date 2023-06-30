/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExerciseClasses;

/**
 *
 * @author Gabriela Gutierrez
 */
public class SimpleCalculator {
    // Method for addition
    public double add(double num1, double num2){
        return num1 + num2;
    }
    // Method for substraction
    public double subtract(double num1, double num2){
        return num1 - num2;
    }
    // Method for multiplication
    public double multiply(double num1, double num2){
        return num1 * num2;
    }
    // Method for division
    public double divide(double num1, double num2){
        try{
            // Checks for infinity or error division
            if(num2 == 0){
                throw new Exception();
            }
        } catch(Exception err){
            System.out.println("Invalid result");
            System.out.println("You cannot divide any number by zero.");
            return -1;
        }
        return num1 / num2;
    }
}
