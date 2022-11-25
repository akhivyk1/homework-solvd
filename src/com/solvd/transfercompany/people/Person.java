package com.solvd.transfercompany.people;


import com.solvd.transfercompany.order.Freighter;
import com.solvd.transfercompany.order.Passenger;

public abstract class Person {
    private String firstName;
    private String lastName;
    private Character sex;

    public Person() {
    }

    public Person(String firstName, String lastName, Character sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public abstract Passenger calculateCostPassenger(Passenger order);

    public abstract Freighter calculateCostFreighter(Freighter order);

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            System.out.println("Имя не может быть пустым.");
            return;
        }
        for (int i = 0; i < firstName.length(); i++) {
            if (!Character.isLetter(firstName.charAt(i))) {
                System.out.println("Не верный формат ввода имени.");
                return;
            }
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            System.out.println("Фамилия не может быть пустая.");
            return;
        }
        for (int i = 0; i < lastName.length(); i++) {
            if (!Character.isLetter(lastName.charAt(i))) {
                System.out.println("Не верный формат ввода фамилии.");
                return;
            }
        }
        this.lastName = lastName;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        if (sex != 'м' && sex != 'ж') {
            System.out.println("Пол введен некорректно.");
            return;
        }
        this.sex = sex;
    }
}
