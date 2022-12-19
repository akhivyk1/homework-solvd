package com.solvd.transfercompany.order;

import com.solvd.transfercompany.people.Driver;

import java.util.function.Function;


public abstract class Order {
    private long id;
    private Function<Integer, Double> cost;
    private double distance;
    private Driver driver;

    public Order() {

    }

    public Order(Function<Integer, Double> cost, double distance, Driver driver, long id) {
        this.cost = cost;
        this.distance = distance;
        this.driver = driver;
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Function<Integer, Double> getCost() {
        return cost;
    }

    public void setCost(Function<Integer, Double> cost) {
        this.cost = cost;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
