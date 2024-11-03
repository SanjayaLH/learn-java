package com.learn.linkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        demoLinkList();

    }
    public static void demoLinkList() {
        List<String> names = new LinkedList<>();
        names.add("a");
        names.add("b");
        names.add("c");

        for (int i=0; i<names.size(); i++ ) {
            System.out.println(names.get(i));
            System.out.println(System.identityHashCode(names.get(i)));
        }
    }
}
