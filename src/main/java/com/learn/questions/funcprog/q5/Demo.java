package com.learn.questions.funcprog.q5;

public class Demo {
    public int applyOperation(int x, int y, Operation operation) {
        return operation.apply(x, y);
    }

    public static void main(String[] args) {
        Operation addition = (x, y) -> x + y;
        Operation multiplication = (x, y) -> x * y;

        Demo demo = new Demo();

        System.out.println("Addition:"+demo.applyOperation(5,3,addition));
        System.out.println("Multiplication:"+demo.applyOperation(5,3,multiplication));

    }
}
