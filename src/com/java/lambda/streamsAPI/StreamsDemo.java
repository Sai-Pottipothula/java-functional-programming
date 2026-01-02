package com.java.lambda.streamsAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.get();

        //print list of all employees
        employees.stream()
                .forEach(e-> System.out.println(e));

        //Salary >20k and lastname starts with "n"
        employees.stream()
                .filter(e->e.getSalary() > 20000.0)
                .filter(e->e.getLastName().startsWith("n"))
                .forEach(e-> System.out.println(e));

        //sort by first name
        employees.stream()
                .sorted((e1,e2)->e1.getFirstName().compareTo(e2.getFirstName()))
                .forEach(e-> System.out.println(e));

        //only first names in sorted order
        employees.stream()
                .map(e->e.getFirstName())
                .sorted()
                .forEach(e-> System.out.println(e));

        //count of employees in development department
        System.out.println(employees.stream()
                .filter(e->e.getDepartment()=="DEV")
                .count());

        //sum of salaries of all employees in "Dev" department
        System.out.println(employees.stream()
                .filter(e->e.getDepartment()=="DEV")
                .mapToDouble(e->e.getSalary())
                .sum());

        //max salary of the employees
        System.out.println(employees.stream()
                .mapToDouble(e->e.getSalary())
                .max());

        //List of employees first names
        List<String> list = employees.stream()
                .map(e->e.getFirstName())
                .toList();
        System.out.println(list);

        List<String> empList = employees.stream()
                .map(e->e.getFirstName())
                .collect(Collectors.toList());
        list.add("Micheal");
        System.out.println(empList);

        //Immutable list of names
        List<String> names = employees.stream()
                .map(e->e.getFirstName())
                .distinct()
                .collect(Collectors.toUnmodifiableList());
        names.add("Harish");
        System.out.println(names);

        //Map of employees data with name as key and salary as value
        Map<String, Double> empsMap = employees.stream()
                .collect(Collectors.toMap(
                        e->e.getFirstName(),
                        e->e.getSalary()
                ));
        System.out.println(empsMap);
    }
}
