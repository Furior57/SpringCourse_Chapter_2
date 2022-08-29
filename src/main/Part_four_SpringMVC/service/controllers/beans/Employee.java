package main.Part_four_SpringMVC.service.controllers.beans;


import java.util.HashMap;
import java.util.Map;

public class Employee {

    private String name;

    private String surname;

    private int salary;

    private String department;

    private String car;

    private Map<String,String> carList;

    public Employee() {
        this.carList = new HashMap<>();
        carList.put("BMW","BMW");
        carList.put("Audi","Audi");
        carList.put("Mercedes-benz","Mercedes");
    }

    public Map<String, String> getCarList() {
        return carList;
    }

    public void setCarList(Map<String, String> carList) {
        this.carList = carList;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
