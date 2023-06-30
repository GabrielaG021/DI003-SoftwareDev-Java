/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gabrielag.day22notes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Gabriela Gutierrez
 */
public class HashMapTest {
    public static void main(String[] args) {
        /*
        // ADDING DATA TO A MAP
        // create a map that maps a country to its population
        Map<String, Integer> populations = new HashMap<>();

        // add the first country
        populations.put("USA", 313000000);

        // add the next country
        populations.put("Canada", 34000000);

        // add another country
        populations.put("United Kingdom", 63000000);

        // add another country
        populations.put("Japan", 127000000);
        
        //System.out.println(populations);
        */
        
        /*
        // REPLACING DATA IN A MAP
        // create a map that maps a country to its population
        Map<String, Integer> populations = new HashMap<>();

        // add the first country
        populations.put("USA", 200000000);

        // add the next country
        populations.put("Canada", 34000000);

        // replace the mapping for population of the USA - original
        // number was too low
        populations.put("USA", 313000000);
        */
        
        /*
        // LOOKING UP VALUES IN A MAP
        // create a map that maps a country to its population
        Map<String, Integer> populations = new HashMap<>();

        // add the first country
        populations.put("USA", 313000000);

        // add another country
        populations.put("Japan", 127000000);

        // get the poplation of Japan and print it to the screen
        Integer japanPopulation = populations.get("Japan");
        System.out.println("The population of Japan is: " + japanPopulation);
        */
        
        /*
        // REMOVING VALUES FROM A MAP
        // create a map that maps a country to its population
        Map<String, Integer> populations = new HashMap<>();

        // add the first country
        populations.put("USA", 200000000);

        // add the next country
        populations.put("Canada", 34000000);

        // remove USA from the map entirely
        populations.remove("USA");
        */
        
        /*
        // LISTING ALL THE KEYS
        // create a map that maps a country to its population
        Map<String, Integer> populations = new HashMap<>();

        // add the first country
        populations.put("USA", 313000000);

        // add the next country
        populations.put("Canada", 34000000);


        // get the Set of keys from the map
        Set<String> keys = populations.keySet();

        // print the keys to the screen
        for (String k : keys) {
            System.out.println(k);
        }
        */
        
        /*
        // LISTING ALL VALUES KEY BY KEY
        // create a map that maps a country to its population
        Map<String, Integer> populations = new HashMap<>();

        // add the first country
        populations.put("USA", 313000000);

        // add the next country
        populations.put("Canada", 34000000);

        // get the Set of keys from the map
        Set<String> keys = populations.keySet();

        // print the keys and associated values to the screen
        for (String k : keys) {
            System.out.println("The population of " + k +
                    " is " + populations.get(k));
        }
        */
        
        /*
        // LISTING ALL THE VALUES: VALUE COLLECTION
        // create a map that maps a country to its population
        Map<String, Integer> populations = new HashMap<>();

        // add the first country
        populations.put("USA", 313000000);

        // add the next country
        populations.put("Canada", 34000000);

        // get the Collection of values from the Map
        Collection<Integer> popValues = populations.values();

        // list all of the population values
        for (Integer p : popValues) {
            System.out.println(p);
        }
        */
    }
}
