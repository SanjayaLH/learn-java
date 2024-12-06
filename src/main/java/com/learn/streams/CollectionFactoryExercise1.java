package com.learn.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Create an immutable Map of employees (ID → Name) using Map.ofEntries for >10 entries.
 * Use List.of and streams to create a list of names, filter those with more than 4 characters,
 * and collect into a Set.
 */
public class CollectionFactoryExercise1 {
    public static void main(String[] args) {
        //Immutable Map of employees
        Map<String, String> employees = Map.ofEntries(
                Map.entry("001", "Sanjeewa"),
                Map.entry("002", "Janaka"),
                Map.entry("003", "Piyal"),
                Map.entry("004", "Kapil"),
                Map.entry("005", "Del"),
                Map.entry("006", "Dil"),
                Map.entry("007", "Wije"),
                Map.entry("008", "Bimal"),
                Map.entry("009", "Renuka"),
                Map.entry("010", "Ravin"));
        System.out.println("Employees Map: "+ employees);

        //Immutable List of names
        List<String> empNames = List.copyOf(employees.values().stream().collect(Collectors.toList()));
        System.out.println("Employees list get from Map: "+empNames);

        Set<String> namesWithMoreThanFourLetters = empNames.stream().filter(name -> name.length() > 4).collect(Collectors.toSet());
        System.out.println("Employee names with more than 4 characters in Map: "+namesWithMoreThanFourLetters);

        //Immutable List of names
        List<String> empNameList = List.of("Piyal", "Kapil", "Del", "Dil", "Wije", "Renuka", "Sanjeewa");
        Set<String> namesWithMoreThanFourLetters2 = empNameList.stream().filter(name -> name.length() > 4).collect(Collectors.toSet());
        System.out.println("Employee names with more than 4 characters: "+namesWithMoreThanFourLetters2);


    }
}
