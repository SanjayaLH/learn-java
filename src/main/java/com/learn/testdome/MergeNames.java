package com.learn.testdome;

import java.util.*;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        Set set = new HashSet();
        set.addAll(Arrays.asList(names1));
        set.addAll(Arrays.asList(names2));

        String[] str = (String[]) set.toArray(new String[0]);

        return str;
    }

    public static void main(String[] args) {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
