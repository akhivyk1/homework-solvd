package com.solvd.transfercompany.order;

public final class IdCounter {
    private static long idCounter;

    static {
        idCounter = 1;
    }

    public IdCounter() {

    }

    public static synchronized long createID() {
        return idCounter++;
    }
}
