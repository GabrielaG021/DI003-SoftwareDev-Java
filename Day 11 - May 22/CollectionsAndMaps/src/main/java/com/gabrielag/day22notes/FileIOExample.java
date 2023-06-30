/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gabrielag.day22notes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author Gabriela Gutierrez
 */
public class FileIOExample {
    public static void main(String[] args) throws Exception {
        // WRITING TO A FILE
//        FileWriter object = new FileWriter("Faith");
//        PrintWriter display = new PrintWriter(object);
        // OR
//        PrintWriter display = new PrintWriter(new FileWriter("Faith"));
//        display.println("this is a line in my file...");
//        display.println("a second line in my file...");
//        display.println("a third line in my file...");
//        display.println("Hello faith, we are testing a file.");
//        display.flush();
//        display.close();
        

        // READING FROM A FILE
        FileReader object = new FileReader("Faith"); // To open the required text file
        BufferedReader bobj = new BufferedReader(object); // Channel or Pipeline between the file and the App
        Scanner sc = new Scanner(bobj); // Display to the screen
        // OR
//        Scanner sc = new Scanner(new BuffferedReader(new FileReader("Faith")));
        // go through the file line by line
        while(sc.hasNextLine()){
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }
        
    }
}
