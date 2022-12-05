package com.solvd.transfercompany.order;

import com.solvd.transfercompany.people.Driver;


public abstract class Order {
    private long id;
    private double cost;
    private double distance;
    private Driver driver;

    public Order() {

    }

    public Order(double cost, double distance, Driver driver, long id) {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
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
