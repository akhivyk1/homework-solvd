package com.solvd.transfercompany.transport;

public class Truck extends Vehicle {
    private double liftingCapacity;

    public Truck() {

    }

    public Truck(String carBrand, int maxSpeed, double liftingCapacity) {
        super(carBrand, maxSpeed);
        this.liftingCapacity = liftingCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" + "carBrand = '" + this.getCarBrand() + '\'' + ", maxSpeed = " + this.getMaxSpeed() + '\'' + ", liftingCapacity = " + liftingCapacity + '}';
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(double liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }
}
