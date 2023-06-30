/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gabrielag.scratchpaper;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Gabriela Gutierrez
 */
public class JavaBasicsStudyList {
    /*//Question 10
    public static void main(String[] args) {
        int a = 10;
        int b = 4;
        float c = 0;
        
        c = (float)a / b;
        System.out.print(c);
    }*/
    
    /*// Question 13
    public static void main(String[] args) {
        int a = 12;
        int b = 13;
        String  C = "Java";

        System.out.println(a + b + C);
        System.out.println(C + b + a);
    }*/
    
    /* // Question 14
    public static void main(String[] args) {
        int a = 12;
        int b = 13;
        String  C = "Java";

        if (a<=b) {
            System.out.println(a + " is less than " + b);
        }
        
        if (a<=b) {
            System.out.println(a + " is less than " + b);
        } else {
            System.out.println("This is false.");
        }
        
        if (C.equals("JAVA")) {
            System.out.println("This is true");
        } else {
            System.out.println("This is all uppercase!");
            if (C.equals("Java")) {
                System.out.println("This one is equal");
            }
        }
    }*/
    
    /*// Question 16
    public static void main(String[] args){
        Random generator = new Random();
        
        int randNum = generator.nextInt(6) + 1;
        
        System.out.println(randNum);
    }*/
    
    /*// Question 17
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        String c = "Java";

        if (a && b ) {
            System.out.println("Both a and b are true");
        } else {
            System.out.println("Both a and b are not true");
        }

        if(a || b) {
            System.out.println("either a or b is true");
        }

        if (a && (b && c.equals("Java"))) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }*/
    
    /*// Question 18
    public static void main(String[] args){
        System.out.println("Counting down...\n");
        
        for(int i=10; i >= 0; i--){
            System.out.println(i);
        }
        
        System.out.println("\nBlast off!");
    }*/
    
    /*// Question 20
    public static void main(String[] args){
        int rows = 6;
        
        for(int i=1; i <= rows; ++i){
            for(int j=1; j <= i; ++j){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }*/
    
    /*// Question 22
    public static void main(String[] args){
        calAreaOfRectangle();
    }
    
    public static void calAreaOfRectangle(){
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Enter length of rectangle: ");
        double length = userInput.nextDouble();
        System.out.println("Enter width of rectangle: ");
        double width = userInput.nextDouble();
        
        double area = length * width;
        
        System.out.println("Area of Rectangle is: " + area);
    }*/
    
    /*// Question 23
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Enter side 1: ");
        double side1 = userInput.nextDouble();
        System.out.println("Enter side 2: ");
        double side2 = userInput.nextDouble();
        System.out.println("Enter side 3: ");
        double side3 = userInput.nextDouble();
        
        double area = areaofTriangle(side1, side2, side3);
        
        System.out.println("Area of a triangle: " + String.format("%.5f", area));
    }
    public static double areaofTriangle(double side1, double side2, double side3){
        double area;
        double semiP = (side1 + side2 + side3) / 2;
        
        area = Math.sqrt(semiP * (semiP-side1) * (semiP-side2) * (semiP-side3));
        return area;
    }*/
    
    // Question 35
    public static void main(String[] args) {
        int[] myArray = new int[]{1,2,3,4,5};
        
        System.out.println("Elements in my array: ");
        
        for(int i=0; i<myArray.length; i++){
            System.out.print(myArray[i] + " ");
        }
    }
}
