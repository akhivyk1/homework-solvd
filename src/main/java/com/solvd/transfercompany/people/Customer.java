package com.solvd.transfercompany.people;

import com.solvd.transfercompany.order.Freighter;
import com.solvd.transfercompany.order.Passenger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Scanner;

public class Customer extends Person {
    private String phoneNumber;
    private double cash;

    private static final Logger logger = LogManager.getLogger();

    public Customer() {
    }

    public Customer(String firstName, String lastName, Character sex, String phoneNumber, double cash) {
        super(firstName, lastName, sex);
        this.phoneNumber = phoneNumber;
        this.cash = cash;
    }

    public Customer fillInfo(Scanner in, Customer person) {
        logger.info("Доброго времени суток, для продолжения давайте заполним некоторые Ваши данные.");
        logger.info("Введите Ваше имя:");
        try {
            person.setFirstName(in.nextLine());
        } catch (PeopleException e) {
            System.out.println(e.getMessage());
            fillInfo(in, person);
        }

        logger.info("Введите Вашу фамилию:");
        try {
            person.setLastName(in.nextLine());
        } catch (PeopleException e) {
            logger.info(e.getMessage());
            fillInfo(in, person);
        }

        logger.info("Введите Ваш пол (м/ж):");
        try {
            person.setSex(in.nextLine().charAt(0));
        } catch (PeopleException e) {
            logger.info(e.getMessage());
            fillInfo(in, person);
        }
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getPhoneNumber(), customer.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Customer{" + "phoneNumber='" + phoneNumber + '\'' + '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Passenger calculateCostPassenger(Passenger order) {
        return null;
    }

    @Override
    public Freighter calculateCostFreighter(Freighter order) {
        return null;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
