/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gabrielag.practiceexercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Gabriela Gutierrez
 */
public class StateCapitals2 {
    public static void main(String[] args) throws FileNotFoundException{
        Map<String, String> stateCapitals = new HashMap<>();
        Scanner in = new Scanner(new BufferedReader(new FileReader("C:\\Users\\gabys\\GitHub Repositories\\DI003-SoftwareDev-Java\\Day 11 - May 22\\CollectionsAndMaps\\src\\main\\java\\com\\gabrielag\\practiceexercises\\StateCapitals.txt")));
        int stateCounter = 0;
        Scanner userInput = new Scanner(System.in);
        String[] place = new String[2];
        String currentLine;
        
        // Load the HashMap with each state/capital pair using this file: StateCapitals.txt
        while(in.hasNextLine()){
            currentLine = in.nextLine();
            place = currentLine.split("::");
            stateCapitals.put(place[0], place[1]);
            stateCounter++;
        }
        System.out.println(stateCounter + " STATES & CAPITALS ARE LOADED.");
        System.out.println("=======================================");
        System.out.println("HERE ARE THE STATES: ");
        for(String s : stateCapitals.keySet()){
            System.out.print(s + ", ");
        }
        System.out.println("");
    }
}
