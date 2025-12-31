package com.java.lambda.defaultstatic;

interface Vehicle{
    String getBrand();
    String speedUp();
    String slowDown();

    default String turnAlarmOn(){
        return "turing vehicle alarm on";
    }
    default String turnAlarmOff(){
        return "tuning vehicle alarm off";
    }

    static String getCompany(){
        return "BMW";
    }
}
class Car implements Vehicle{
    @Override
    public String getBrand() {
        return "BMW";
    }

    @Override
    public String speedUp() {
        return "the car is speeding up";
    }

    @Override
    public String slowDown() {
        return "the car is slowing down";
    }
}
public class DefaultDemo{
    public static void main(String[] args) {
        Car vehicle = new Car();
        System.out.println(vehicle.getBrand());
        System.out.println(vehicle.speedUp());
        System.out.println(vehicle.slowDown());

        System.out.println(vehicle.turnAlarmOff());
        System.out.println(vehicle.turnAlarmOn());

        System.out.println(Vehicle.getCompany());
    }
}
