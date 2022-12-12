package com.solvd.transfercompany.order;

import com.solvd.transfercompany.people.Driver;
import com.solvd.transfercompany.transport.Minivan;

import java.util.Objects;

public class Passenger extends Order {
    private Minivan minivan;

    public Passenger() {

    }

    public Passenger(double cost, double distance, Driver driver, long id, Minivan minivan) {
        super(cost, distance, driver, id);
        this.minivan = minivan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger passenger)) return false;
        return getMinivan().equals(passenger.getMinivan());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMinivan());
    }

    @Override
    public String toString() {
        return "Passenger order{" + "id=" + this.getId() + ", cost=" + this.getCost() + ", distance=" + this.getDistance() + ", driver=" + this.getDriver() + '}' + "minivan=" + minivan + '}';

    }

    public Minivan getMinivan() {
        return minivan;
    }

    public void setMinivan(Minivan minivan) {
        this.minivan = minivan;
    }
}
