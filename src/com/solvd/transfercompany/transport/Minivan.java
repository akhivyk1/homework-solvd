package com.solvd.transfercompany.transport;

public class Minivan extends Vehicle {
    private int passengerPlaces;

    public Minivan() {

    }

    public Minivan(String carBrand, int maxSpeed, int passengerPlaces) {
        super(carBrand, maxSpeed);
        this.passengerPlaces = passengerPlaces;
    }

    @Override
    public String toString() {
        return "Minivan{" + "carBrand = '" + this.getCarBrand() + '\'' + ", maxSpeed = " + this.getMaxSpeed() + '\'' + ", passengerPlaces = " + passengerPlaces + '}';
    }

    public int getPassengerPlaces() {
        return passengerPlaces;
    }

    public void setPassengerPlaces(int passengerPlaces) {
        this.passengerPlaces = passengerPlaces;
    }
}
