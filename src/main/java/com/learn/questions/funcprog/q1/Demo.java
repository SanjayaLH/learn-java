package com.learn.questions.funcprog.q1;

public class Demo {

    public static void main(String[] args) {
        StringProcessor toUpperCase = message -> message.toUpperCase();
        System.out.println("Upper case the message:" + toUpperCase.process("Hello"));

        StringProcessor toReverse = message -> new StringBuilder(message).reverse().toString();
        System.out.println("Reverse the message:" + toReverse.process("Hello"));
    }
}
