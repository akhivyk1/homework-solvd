package com.solvd.transfercompany.order;

public class IdCounter {
    private static long idCounter = 1;

    public IdCounter() {

    }

    public static synchronized long createID() {
        return idCounter++;
    }
}
