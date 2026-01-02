package com.java.lambda.streamsAPI;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private String jobTitle;
    private double salary;
    private int age;

    public Employee(int id, String firstName, String lastName, String department, String jobTitle, double salary, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.age = age;
    }

    public String toString(){
        return "Employee{"+
                "id="+id+
                ", firstName=" + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                ", department=" + department + '\'' +
                ", jobTitle="+ jobTitle + '\'' +
                ", salary=" + salary + '\'' +
                ", age=" + age +
                '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
