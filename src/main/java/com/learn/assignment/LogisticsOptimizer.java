package com.learn.assignment;

import com.learn.priorityQueue.Patient;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Logistics Optimization for a Delivery System
 * Problem Statement:
 * <p>
 * A logistics company is optimizing its package delivery system.
 * Each package has a unique ID, weight, and destination city. The goal is to:
 * Process and store all incoming packages efficiently.
 * <p>
 * Identify duplicate packages based on their unique IDs.
 * Prioritize delivery based on package weight (heavier packages should be delivered first).
 * Allow efficient retrieval of packages for each destination city.
 * Simulate delivery in the order of priority while ensuring that no duplicates are processed.
 * <p>
 * class Package {
 * String id;
 * double weight;
 * String city;
 * <p>
 * public Package(String id, double weight, String city) {
 * this.id = id;
 * this.weight = weight;
 * this.city = city;
 * }
 *
 * @Override public String toString() {
 * return "Package{id='" + id + "', weight=" + weight + ", city='" + city + "'}";
 * }
 * }
 * <p>
 * List<Package> incomingPackages = Arrays.asList(
 * new Package("P1", 10.5, "New York"),
 * new Package("P2", 5.3, "Los Angeles"),
 * new Package("P3", 12.0, "New York"),
 * new Package("P1", 10.5, "New York"),  // Duplicate
 * new Package("P4", 8.7, "Chicago"),
 * new Package("P5", 15.0, "Los Angeles")
 * );
 * <p>
 * <p>
 * Packages grouped by destination city:
 * New York: [Package{id='P1', weight=10.5, city='New York'}, Package{id='P3', weight=12.0, city='New York'}]
 * Los Angeles: [Package{id='P2', weight=5.3, city='Los Angeles'}, Package{id='P5', weight=15.0, city='Los Angeles'}]
 * Chicago: [Package{id='P4', weight=8.7, city='Chicago'}]
 * <p>
 * Simulating delivery (priority by weight):
 * Delivering: Package{id='P5', weight=15.0, city='Los Angeles'}
 * Delivering: Package{id='P3', weight=12.0, city='New York'}
 * Delivering: Package{id='P1', weight=10.5, city='New York'}
 * Delivering: Package{id='P4', weight=8.7, city='Chicago'}
 * Delivering: Package{id='P2', weight=5.3, city='Los Angeles'}
 */
public class LogisticsOptimizer {
    private final Queue<Package> packageQueue;
    private final Set<Package> incomingPkgs;

    public LogisticsOptimizer() {
        //System.out.println("------------In LogisticsOptimizer()--------------");
        incomingPkgs = new HashSet<>();
        packageQueue = new PriorityQueue<>();
    }

    public void removeDuplicates(Package newPackage) {
        //System.out.println("------------In removeDuplicates()--------------");
        if (incomingPkgs.add(newPackage)) { // `add` returns false if the item is already present
            System.out.println("Pkg added: " + newPackage);
        } else {
            System.out.println("This is duplicate, pkg is ignored: " + newPackage);
        }
    }

    public void storePackages() {
        ///System.out.println("------------In storePackages()--------------");
        packageQueue.addAll(incomingPkgs);
    }

    public void groupPackagesBasedOnDestinationCity() {
        List<Package> plist = new ArrayList<>();

        String city = null;
        for (Package p : incomingPkgs) {
            city = p.getCity();
            if (p.getCity().equals(city)) {
                plist.add(p);
              System.out.println(p.getCity()+" :"+p);
          }
        }
        System.out.println("Groups in " + city + ": " + plist);
    }

    public Optional<Package> deliverPkgs() {
        //System.out.println("------------In deliverPkgs()--------------");
        return Optional.ofNullable(packageQueue.poll())
                .map(pack -> {
                    System.out.println("Delivered : " + pack);
                    return pack;
                });
    }

    public static void main(String[] args) {
        LogisticsOptimizer logisticsOptimizer = new LogisticsOptimizer();

        logisticsOptimizer.removeDuplicates(new Package("P1", 10.5, "New York"));
        logisticsOptimizer.removeDuplicates(new Package("P2", 5.3, "Los Angeles"));
        logisticsOptimizer.removeDuplicates(new Package("P3", 12.0, "New York"));
        logisticsOptimizer.removeDuplicates(new Package("P1", 10.5, "New York"));
        logisticsOptimizer.removeDuplicates(new Package("P4", 8.7, "Chicago"));
        logisticsOptimizer.removeDuplicates(new Package("P5", 15.0, "Los Angeles"));

        logisticsOptimizer.storePackages();

        logisticsOptimizer.groupPackagesBasedOnDestinationCity();

        Optional<Package> pkg1 = logisticsOptimizer.deliverPkgs();
        pkg1.ifPresent(pkg -> System.out.println(pkg.getWeight() + " Delivered"));

        Optional<Package> pkg2 = logisticsOptimizer.deliverPkgs();
        pkg2.ifPresent(pkg -> System.out.println(pkg.getWeight() + " Delivered"));

        Optional<Package> pkg3 = logisticsOptimizer.deliverPkgs();
        pkg3.ifPresent(pkg -> System.out.println(pkg.getWeight() + " Delivered"));

        Optional<Package> pkg4 = logisticsOptimizer.deliverPkgs();
        pkg4.ifPresent(pkg -> System.out.println(pkg.getWeight() + " Delivered"));

        Optional<Package> pkg5 = logisticsOptimizer.deliverPkgs();
        pkg5.ifPresent(pkg -> System.out.println(pkg.getWeight() + " Delivered"));

        Optional<Package> pkg6 = logisticsOptimizer.deliverPkgs();
        pkg6.ifPresent(pkg -> System.out.println(pkg.getWeight() + " Delivered"));

    }
}