/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gabrielag.day22notes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriela Gutierrez
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        
        //For loop to Manipulate the data in a linked list
        for(int i=0; i< strings.size(); i++){
            System.out.println(strings.get(i));
        }
        System.out.println("");
        
        strings.add(1, "D");
        
        for(String s : strings){
            System.out.println(s);
        }
        System.out.println("");
        
        strings.remove("D");
        //For loop to read the data in a linked list
        for(String s : strings){
            System.out.println(s);
        }
        System.out.println("");
        
        strings.remove(1);
        
        for(String s : strings){
            System.out.println(s);
        }
        System.out.println("");
    }
}
