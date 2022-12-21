package com.solvd.transfercompany.people;

import com.solvd.transfercompany.order.Freighter;
import com.solvd.transfercompany.order.Passenger;

import java.util.Objects;
import java.util.function.Function;

public class Logistician extends Person {
    private double salary;

    public Logistician() {

    }

    public Logistician(String firstName, String lastName, Character sex, int salary) {
        super(firstName, lastName, sex);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Logistician that)) return false;
        return getSalary() == that.getSalary();
    }

    @Override
    public String toString() {
        return "Logistician{" + "firstName = '" + this.getFirstName() + '\'' + ", lastName = '" + this.getLastName() + '\'' + ", sex = " + this.getSex() + '\'' + ", salary = " + salary + '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(getSalary());
    }

    @Override
    public Freighter calculateCostFreighter(Freighter order) {
        Function<Integer, Double> finalCost;
        if (order.getDistance() < 100) {
            finalCost = a -> order.getDistance() / 0.8;
        } else {
            finalCost = a -> order.getDistance() / 0.6;
        }
        order.setCost(finalCost);
        return order;
    }

    @Override
    public Passenger calculateCostPassenger(Passenger order) {
        Function<Integer, Double> finalCost;
        finalCost = a -> order.getDistance() * 0.7;
        order.setCost(finalCost);
        return order;
    }

}
