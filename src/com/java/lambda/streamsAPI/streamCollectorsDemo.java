package com.java.lambda.streamsAPI;

import java.util.*;
import java.util.stream.Collectors;

public class streamCollectorsDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.get();

        //Joining the data
        //Concat the firstnames of all the employees
        //static Collector<CharSequence,?,String> joining(CharSequence delimiter)
        System.out.println(employees.stream()
                .map(e -> e.getFirstName())
                .collect(Collectors.joining(", ")));

        //Partitioning the data
        //split the list based on salary > 25000.0
        //static <T> Collector<T,?,Map<Boolean,List<T>>> partitioningBy(Predicate<? super T> predicate)
        System.out.println(employees.stream()
                .collect(Collectors.partitioningBy(e->e.getSalary()>25000.0)));

        //split the list based on salary > 25000.0 - but count only
        //static <T,D,A> Collector<T,?,Map<Boolean,D>> partitionBy(Predicate<? super T> predicate, Collectors<? super T,A,D> downstream
        Map<Boolean, Long> empsCountBySal25k = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 25000.0, Collectors.counting()));
        System.out.println(empsCountBySal25k);

        //Grouping the data
        //Group the employees by their department
        //static <T,K> Collector<T,?,Map<K, List<T>>> groupingBy(Function<? super T,? extends K> classifier)
        Map<String, List<Employee>> empsByDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
        System.out.println(empsByDept);

        //Group the employees by their department- count the employees by each department
        Map<String, Long> empsCountByDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));
        System.out.println(empsCountByDept);

        //Group the employees by their department - List the employee names by each department
        //static <T,U,A,R> Collector <T,?,R> mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream
        Map<String, List<String>> empNamesByDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.mapping(e -> e.getFirstName(), Collectors.toList())));
        System.out.println(empNamesByDept);

        //Group the employees by their department - sum the salaries of employees by each department
        //static<T> Collector<T,?,Optional<T>> reducing(BinaryOperator<T> op)
        Map<String, Optional<Double>> sumOfSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.mapping(e -> e.getSalary(), Collectors.reducing((a, b) -> a + b))));
        System.out.println(sumOfSalaryByDept);

        //static <T> Collector<T,?,Double> summingDouble(ToDoubleFunction<? super T> mapper)
        Map<String, Double> sumOfSalaryByDept2 = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.summingDouble(e -> e.getSalary())));
        System.out.println(sumOfSalaryByDept2);

        //Group the employees by their department - summary statistics of the salaries of employees by each department
        //static <T> Collector<T,?,DoubleSummary<Statistics> summarizingDouble(ToDoubleFunction<? super T> mapper)
        Map<String, DoubleSummaryStatistics> summaryEmpSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(),
                        Collectors.summarizingDouble(e -> e.getSalary())));
        System.out.println(summaryEmpSalaryByDept);

        //summary statistics of the salaries of employees in Dev department ONLY
        //static <T,A,R> Collector<T,?,R> filtering (Predicate<? super T> predicate, Collector<? super T,A,R> downstream)
        DoubleSummaryStatistics devEmpSalarySummary = employees.stream()
                .collect(Collectors.filtering(e -> e.getDepartment().equals("DEV"),
                        Collectors.summarizingDouble(e -> e.getSalary())));
        System.out.println(devEmpSalarySummary);

        //Employee with highest age
        //static <T> Collector<T,?,Optional<T>> maxBy(Comparator<? super T> comparator)
        System.out.println(employees.stream()
                .collect(Collectors.maxBy((e1,e2)-> e1.getAge()-e2.getAge())));

        System.out.println(employees.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getAge))));

        //Name of the employee with highest salary
        String empNameWithHighSalary = employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                        empOpt -> empOpt.map(Employee::getFirstName).orElse("Name not found")));
        System.out.println(empNameWithHighSalary);
    }
}
