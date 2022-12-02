package com.solvd.transfercompany.people;

import com.solvd.transfercompany.order.Freighter;
import com.solvd.transfercompany.order.Passenger;

public class Driver extends Person {
    private Character drivingCategory;
    private double salary;

    public Driver() {

    }

    public Driver(String firstName, String lastName, Character sex, Character drivingCategory, double salary) {
        super(firstName, lastName, sex);
        this.drivingCategory = drivingCategory;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "firstName = '" + this.getFirstName() + '\'' + ", lastName = '" + this.getLastName() + '\'' + ", sex = " + this.getSex() + '\'' + ", salary = " + salary + '\'' + ", drivingCategory = " + drivingCategory + '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Character getDrivingCategory() {
        return drivingCategory;
    }

    public void setDrivingCategory(Character drivingCategory) {
        this.drivingCategory = drivingCategory;
    }

    @Override
    public Passenger calculateCostPassenger(Passenger order) {
        return null;
    }

    @Override
    public Freighter calculateCostFreighter(Freighter order) {
        return null;
    }
}
