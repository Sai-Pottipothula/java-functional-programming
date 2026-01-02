package com.java.lambda.streamsAPI;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeData {
    public static ArrayList<Employee> get(){
        return new ArrayList<Employee>(Arrays.asList(
                new Employee(1, "balu", "naidu", "DEV", "VP", 25000.00, 23),
                new Employee(2, "mohan", "nageswarao", "DEV", "SE", 24000.00, 23),
                new Employee(3, "rohit", "pottipothula", "ADMIN", "VP", 27000.00, 19),
                new Employee(4, "aravind", "narayana", "HR", "HR", 19000.00, 25),
                new Employee(5, "chinnu", "satti", "HR", "DBA", 21000.00, 25),
                new Employee(6, "nani", "nayudu", "HR", "DEVOPS", 23000.00, 30)
        ));
    }
}
