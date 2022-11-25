package com.solvd.transfercompany.order;

import com.solvd.transfercompany.people.Driver;
import com.solvd.transfercompany.transport.Truck;

public class Freighter extends Order {
    private Truck truck;

    public Freighter() {

    }

    public Freighter(double cost, double distance, Driver driver, long id, Truck truck) {
        super(cost, distance, driver, id);
        this.truck = truck;
    }

    @Override
    public String toString() {
        return "Freighter order{" + "id=" + this.getId() + ", cost=" + this.getCost() + ", distance=" + this.getDistance() + ", driver=" + this.getDriver() + '}' + "truck=" + truck + '}';

    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
