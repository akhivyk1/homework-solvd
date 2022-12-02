package com.solvd.transfercompany.people;

import com.solvd.transfercompany.order.Freighter;
import com.solvd.transfercompany.order.Passenger;

import java.util.Objects;
import java.util.Scanner;

public class Customer extends Person {
    private String phoneNumber;
    private Currency TypeOfValue;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Character sex, String phoneNumber, Currency TypeOfValue) {
        super(firstName, lastName, sex);
        this.phoneNumber = phoneNumber;
        this.TypeOfValue = TypeOfValue;
    }

    public Customer fillInfo(Scanner in, Customer person) {
        System.out.println("Доброго времени суток, для продолжения давайте заполним некоторые Ваши данные.");
        System.out.println("Введите Ваше имя:");
        person.setFirstName(in.nextLine());

        System.out.println("Введите Вашу фамилию:");
        person.setLastName(in.nextLine());

        System.out.println("Введите Ваш пол (м/ж):");
        person.setSex(in.nextLine().charAt(0));
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

    public Currency getTypeOfValue() {
        return TypeOfValue;
    }

    public void setTypeOfValue(Currency typeOfValue) {
        TypeOfValue = typeOfValue;
    }
}
