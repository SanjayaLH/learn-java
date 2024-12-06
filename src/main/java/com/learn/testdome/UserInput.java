package com.learn.testdome;

public class UserInput {

    public static class TextInput {
        private String currentValue;
        public void add(char c){
            currentValue = String.valueOf(c);
        }

        public String getValue(){
            return currentValue;
        }
    }

    public static class NumericInput extends TextInput{
        private String currentValue;
        @Override
        public void add(char c) {
            currentValue = String.valueOf(c);
            currentValue = currentValue.replaceAll("[^0-9.]", "");
        }
        @Override
        public String getValue(){
            return currentValue;
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}