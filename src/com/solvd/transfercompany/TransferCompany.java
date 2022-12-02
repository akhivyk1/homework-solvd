package com.solvd.transfercompany;

import com.solvd.transfercompany.order.Freighter;
import com.solvd.transfercompany.order.IdCounter;
import com.solvd.transfercompany.order.Passenger;
import com.solvd.transfercompany.people.Driver;
import com.solvd.transfercompany.people.Logistician;
import com.solvd.transfercompany.transport.Minivan;
import com.solvd.transfercompany.transport.Truck;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TransferCompany {
    private ArrayList<Logistician> allLogisticans;
    private ArrayList<Freighter> allFreighterOrders;
    private ArrayList<Driver> allDrivers;
    private ArrayList<Truck> allTrucks;
    private ArrayList<Passenger> allPassengerOrders;
    private ArrayList<Minivan> allMinivans;

    public TransferCompany() {
        allLogisticans = new ArrayList<Logistician>();
        allFreighterOrders = new ArrayList<Freighter>();
        allPassengerOrders = new ArrayList<Passenger>();
        allDrivers = new ArrayList<Driver>();
        allTrucks = new ArrayList<Truck>();
        allMinivans = new ArrayList<Minivan>();
        this.fillDrivers();
        this.fillLogistician();
        this.fillTrucks();
        this.fillMinivans();
    }

    public ArrayList<Logistician> fillLogistician() {
        allLogisticans.add(new Logistician("Степан", "Шарупин", 'м', 320));
        allLogisticans.add(new Logistician("Василий", "Долгинов", 'м', 430));
        allLogisticans.add(new Logistician("Ирина", "Кривошеина", 'ж', 370));
        allLogisticans.add(new Logistician("Юрий", "Шаляпин", 'м', 300));
        allLogisticans.add(new Logistician("Анастасия", "Вальховская", 'ж', 368));
        return allLogisticans;
    }

    public ArrayList<Driver> fillDrivers() {
        allDrivers.add(new Driver("Александр", "Долгачев", 'м', 'E', 550.5));
        allDrivers.add(new Driver("Дмитрий", "Петрухин", 'м', 'E', 550.5));
        allDrivers.add(new Driver("Роман", "Прохоров", 'м', 'E', 550.5));
        return allDrivers;
    }

    public ArrayList<Driver> fillDrivers(Driver first, Driver second, Driver third) {
        allDrivers.add(first);
        allDrivers.add(second);
        allDrivers.add(third);
        return allDrivers;
    }

    public ArrayList<Truck> fillTrucks() {
        allTrucks.add(new Truck("Mercedes-Benz Actros MP3", 200, 4.5));
        allTrucks.add(new Truck("Scania R420", 200, 5.5));
        allTrucks.add(new Truck("MAN 18403", 180, 3.5));
        return allTrucks;
    }

    public ArrayList<Minivan> fillMinivans() {
        allMinivans.add(new Minivan("Mercedes-Benz Vito 3", 240, 7));
        allMinivans.add(new Minivan("Mercedes-Benz V-class Q230", 240, 7));
        allMinivans.add(new Minivan("Mercedes-Benz V-class W447", 240, 7));
        return allMinivans;
    }

    public ArrayList<Freighter> addFreighterOrder(Scanner in) {
        System.out.println("Для создания грузовой перевозки необходимо заполнить следущие поля.");
        Freighter order = new Freighter();
        System.out.println("Введите расстояние перевозки:");
        order.setDistance(Double.parseDouble(in.nextLine()));
        Random rand = new Random();
        allLogisticans.get(rand.nextInt(allLogisticans.size())).calculateCostFreighter(order);
        System.out.println("Стоимость перевоза груза - " + order.getCost() + "\nДля подтверждения перевозки " +
                "введите 1. Если хотите отказаться, введите 2");
        if (Integer.parseInt(in.nextLine()) == 1) {
            order.setDriver(allDrivers.get(rand.nextInt(allDrivers.size())));
            order.setId(IdCounter.createID());
            order.setTruck(allTrucks.get(rand.nextInt(allTrucks.size())));
            allFreighterOrders.add(order);
            System.out.println("Заказ на перевозку груза создан.\nУникальный идентификатор заказа: " + order.getId() + "\nДистанция перевозки груза: " + order.getDistance() + "\nВодитель: " + order.getDriver().toString() + "\nМашина: " + order.getTruck().toString());
        } else {
            System.out.println("Вы отказались от перевозки.");
        }
        return allFreighterOrders;
    }

    public ArrayList<Passenger> addPassengerOrder(Scanner in) {
        System.out.println("Что бы заказать трансфер людей, заполните поля.");
        Passenger order = new Passenger();
        System.out.println("Введите расстояние перевозки:");
        double distance = Double.parseDouble(in.nextLine());
        order.setDistance(distance);
        System.out.println("Введите количество перевозимых пассажиров:");
        if (Integer.parseInt(in.nextLine()) <= 7) {
            Random rand = new Random();
            allLogisticans.get(rand.nextInt(allLogisticans.size())).calculateCostPassenger(order);
            System.out.println("Стоимость трансфера пассажиров - " + order.getCost() + "\nДля подтверждения перевозки " +
                    "введите 1. Если хотите отказаться, введите 2");
            if (Integer.parseInt(in.nextLine()) == 1) {
                order.setDriver(allDrivers.get(rand.nextInt(allDrivers.size())));
                order.setId(IdCounter.createID());
                order.setMinivan(allMinivans.get(rand.nextInt(allTrucks.size())));
                allPassengerOrders.add(order);
                System.out.println("Заказ на трансфер пссажиров успешно создан.\nУникальный идентификатор заказа: " + order.getId() + "\nДистанция трансфера: " + order.getDistance() + "\nВодитель: " + order.getDriver().toString() + "\nМашина: " + order.getMinivan().toString());
            } else {
                System.out.println("Вы отказались от перевозки.");
            }
        } else {
            System.out.println("Приносим свои извинения, трансфер такого количества людей в нащей компании невозможен.\nКоличество перевозмых пассажиров должно быть не больше 7.");
        }

        return allPassengerOrders;
    }

    @Override
    public String toString() {
        return "TransferCompany{" +
                "\nallLogisticans=" + allLogisticans +
                "\nallFreighterOrders=" + allFreighterOrders +
                "\nallDrivers=" + allDrivers +
                "\nallTrucks=" + allTrucks +
                "\nallPassengerOrders=" + allPassengerOrders +
                "\nallMinivans=" + allMinivans +
                '}';
    }

    public ArrayList<Freighter> getAllFreighterOrders() {
        return allFreighterOrders;
    }

    public void setAllFreighterOrders(ArrayList<Freighter> allFreighterOrders) {
        this.allFreighterOrders = allFreighterOrders;
    }

    public ArrayList<Logistician> getAllLogisticans() {
        return allLogisticans;
    }

    public void setAllLogisticans(ArrayList<Logistician> allLogisticans) {
        this.allLogisticans = allLogisticans;
    }

    public ArrayList<Passenger> getAllPassengerOrders() {
        return allPassengerOrders;
    }

    public void setAllPassengerOrders(ArrayList<Passenger> allPassengerOrders) {
        this.allPassengerOrders = allPassengerOrders;
    }

    public ArrayList<Driver> getAllDrivers() {
        return allDrivers;
    }

    public void setAllDrivers(ArrayList<Driver> allDrivers) {
        this.allDrivers = allDrivers;
    }

    public ArrayList<Truck> getAllTrucks() {
        return allTrucks;
    }

    public void setAllTrucks(ArrayList<Truck> allTrucks) {
        this.allTrucks = allTrucks;
    }

    public ArrayList<Minivan> getAllMinivans() {
        return allMinivans;
    }

    public void setAllMinivans(ArrayList<Minivan> allMinivans) {
        this.allMinivans = allMinivans;
    }
}
