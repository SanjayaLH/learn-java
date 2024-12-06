package com.learn.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        demoHashSet();
        printUnicUsers();
        printUsersInOrderToLogIn();
        printUsersInSortedOrder();
    }

    public static void demoHashSet() {

        Set<String> names = new HashSet<>();

        names.add("aa");
        names.add("bb");
        names.add("cc");
        names.add("aa");

        System.out.println(names);
        System.out.println("Is aa exists:" + names.contains("aa"));
    }
    /*You want to keep track of unique user IDs who have logged in on a particular day.
     Users might log in multiple times, but you only want to store each user ID once.*/

    public static void printUnicUsers() {
        Set<String> userIdSet = new HashSet<String>();

        userIdSet.add("user1");
        userIdSet.add("user2");
        userIdSet.add("user2");
        userIdSet.add("user3");
        userIdSet.add("user4");

        System.out.println("List of users:" + userIdSet);
    }

    /**
     * Now, you need to generate a daily login report that shows users in the order they logged in.
     * Since HashSet does not maintain any order, the report does not accurately reflect the sequence of logins.
     */

    public static void printUsersInOrderToLogIn() {
        Set<String> userIdSet = new LinkedHashSet<>();

        userIdSet.add("user1");
        userIdSet.add("user3");
        userIdSet.add("user2");
        userIdSet.add("user3");
        userIdSet.add("user4");

        System.out.println("List of users:" + userIdSet);

    }

    /**
     * Problem:
     * Your reporting requirements change again, and now you need to display users in a sorted
     * (alphabetical or numerical) order.
     * LinkedHashSet preserves insertion order, but it does not sort the data.
     */
    public static void printUsersInSortedOrder() {
        Set<String> userIdSet = new TreeSet<String>();
        userIdSet.add("user2");
        userIdSet.add("user3");
        userIdSet.add("user4");
        userIdSet.add("user3");
        userIdSet.add("user1");
        userIdSet.add("user2");

        System.out.println("List of users:" + userIdSet);

    }
}
