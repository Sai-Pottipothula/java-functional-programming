package com.java.lambda.functional;

import java.util.function.Function;

class FunctionImpl implements Function<String, Integer> {
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
public class FunctionDemo {
    public static void main(String[] args) {
        //using class
        Function<String, Integer> obj = new FunctionImpl();
        System.out.println(obj.apply("SureshKumar"));

        //using lambda expressions
        Function<String, Integer> obj1 = (s)-> s.length();
        System.out.println(obj1.apply("Ramesh"));
    }
}
