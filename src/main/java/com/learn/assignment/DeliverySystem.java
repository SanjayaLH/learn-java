package com.learn.assignment;

import java.util.*;

public class DeliverySystem {
    public static void main(String[] args) {
        // Step 1: Raw data
        List<Package> incomingPackages = Arrays.asList(
                new Package("P1", 10.5, "New York"),
                new Package("P2", 5.3, "Los Angeles"),
                new Package("P3", 12.0, "New York"),
                new Package("P1", 10.5, "New York"),  // Duplicate
                new Package("P4", 8.7, "Chicago"),
                new Package("P5", 15.0, "Los Angeles")
        );

        // Step 2: Remove duplicates using HashSet
        Set<String> uniqueIds = new HashSet<>();
        ArrayList<Package> filteredPackages = new ArrayList<>();
        for (Package pkg : incomingPackages) {
            if (uniqueIds.add(pkg.id)) {
                filteredPackages.add(pkg);
            }
        }

        // Step 3: Group by city using a Map
        Map<String, LinkedList<Package>> cityGroups = new HashMap<>();
        for (Package pkg : filteredPackages) {
            cityGroups.computeIfAbsent(pkg.city, k -> new LinkedList<>()).add(pkg);
        }

        // Step 4: Prioritize packages for delivery
        PriorityQueue<Package> deliveryQueue = new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight));
        deliveryQueue.addAll(filteredPackages);

        // Step 5: Output grouped packages by city
        System.out.println("Packages grouped by destination city:");
        cityGroups.forEach((city, packages) -> {
            System.out.println(city + ": " + packages);
        });

        // Step 6: Simulate delivery
        System.out.println("\nSimulating delivery (priority by weight):");
        while (!deliveryQueue.isEmpty()) {
            System.out.println("Delivering: " + deliveryQueue.poll());
        }
    }
}
