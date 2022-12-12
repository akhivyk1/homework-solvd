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

    public void setFirstName(String firstName) throws PeopleException {
        if (firstName.isEmpty()) {
            throw new PeopleException("Имя не может быть пустым.");
        }
        for (int i = 0; i < firstName.length(); i++) {
            if (!Character.isLetter(firstName.charAt(i))) {
                throw new PeopleException("Не правильный формат ввода имени.");
            }
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws PeopleException {
        if (lastName.isEmpty()) {
            throw new PeopleException("Фамилия не может быть пустая.");
        }
        for (int i = 0; i < lastName.length(); i++) {
            if (!Character.isLetter(lastName.charAt(i))) {
                throw new PeopleException("Не верный формат ввода фамилии.");
            }
        }
        this.lastName = lastName;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) throws PeopleException {
        if (sex != 'м' && sex != 'ж') {
            throw new PeopleException("Пол введен некорректно.");
        }
        this.sex = sex;
    }
}
