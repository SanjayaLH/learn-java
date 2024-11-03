package com.learn.arraylist;

public class ModulesOperator {
    private static class Node {
        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args) {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        Node node2 = new Node(1, null);
        Node node1 = new Node(2, node2);
        Node[] st = {node1, node2};

        System.out.println(st[0]);


        /*int loopCount = 10;

        for (int i = 0; i < loopCount; i++) {
            // Use modulus to cycle through array indices
            String color = colors[i % colors.length];
            System.out.println("Color " + (i + 1) + ": " + color);
        }*/
    }
}
