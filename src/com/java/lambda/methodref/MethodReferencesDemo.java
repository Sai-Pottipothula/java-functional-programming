package com.java.lambda.methodref;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Printable{
    void print(String msg);
}

public class MethodReferencesDemo {

    public void display(String msg){
        msg = msg.toUpperCase();
        System.out.println(msg);
    }
    public static int addition(int a, int b){
        return a+b;
    }

    public static void main(String[] args) {
        //1. Method reference to a static method

        //lambda expression
        Function<Integer, Double> function = (input)-> Math.sqrt(input);
        System.out.println(function.apply(4));

        //using method reference
        Function<Integer, Double> functionMethodRef = Math::sqrt;
        System.out.println(function.apply(4));

        //lambda expression
        BiFunction<Integer, Integer, Integer> biFunctionLambda = (a, b)-> MethodReferencesDemo.addition(a, b);
        System.out.println(biFunctionLambda.apply(10, 20));

        //using method reference
        BiFunction<Integer, Integer, Integer> biFunction = MethodReferencesDemo::addition;
        System.out.println(biFunctionLambda.apply(10, 20));

        //2. Method reference to an instance method of an object
        MethodReferencesDemo methodReferencesDemo = new MethodReferencesDemo();

        //lambda expression
        Printable printable = (msg)-> methodReferencesDemo.display(msg);
        printable.print("hello world");

        //using method reference
        Printable printableMethodRef = methodReferencesDemo::display;
        printableMethodRef.print("hello world");

        //3. Reference to an instance method of an arbitrary object
        //Sometimes, we call a method of argument in the lambda expression
        //In that case, we can use a method reference to call an instance
        //method of an arbitrary object of a specific type

        //using lambda expression
        Function<String, String> stringFunction = (input)-> input.toLowerCase();
        System.out.println(stringFunction.apply("HUMAN BEING"));

        //using method reference
        Function<String, String> stringFunctionMethodRef = String::toLowerCase;
        System.out.println(stringFunctionMethodRef.apply("HUMAN BEING"));

        //4.reference to a constructor
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Pineapple");
        fruits.add("Orange");
        fruits.add("Blueberries");
        fruits.add("Grapes");

        //using lambda expression
        Function<List<String>, Set<String>> setFunction = (fruitsItem)-> new HashSet<>(fruitsItem);
        System.out.println(setFunction.apply(fruits));

        //using method reference
        Function<List<String>, Set<String>> setFunctionMethodRef = HashSet::new;
        System.out.println(setFunctionMethodRef.apply(fruits));
    }
}
