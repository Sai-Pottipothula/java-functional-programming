package com.java.lambda.functional;

import java.util.function.Consumer;

class ConsumerImpl implements Consumer<String> {
    @Override
    public void accept(String input) {
        System.out.println(input);
    }
}
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = new ConsumerImpl();
        consumer.accept("Enter your username:");

        //Using lambda expression
        Consumer<String> obj = (input)-> System.out.println(input);
        obj.accept("Enter your password:");
    }
}
