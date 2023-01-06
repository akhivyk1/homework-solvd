package com.solvd.transfercompany.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Name;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.SimpleDateFormat;


class Threads implements Runnable {
    private String NameThread;

    private boolean isOne = true;
    private boolean isSecond = true;
    private int count = 0;
    private static final Logger logger = LogManager.getLogger();


    public Threads(String nameThread) {
        NameThread = nameThread;
    }

    @Override
    public void run() {
        while (!isOne) {
            try {
                Thread.sleep(99);
            } catch (InterruptedException e) {
                logger.debug(e);
                throw new RuntimeException(e);
            }
        }
        isOne = !isSecond;
        logger.info("Run -- " + NameThread + " ///// " + new SimpleDateFormat("hh:mm:ss").format(new Date()));

        while (!isSecond) {
            try {
                Thread.sleep(133);
            } catch (InterruptedException e) {
                logger.debug(e);
                throw new RuntimeException(e);
            }
        }
        isSecond = !isOne;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.debug(e);
            throw new RuntimeException(e);
        }
        logger.info("Поток " + NameThread + " завершил работу.");
        count++;
    }
}

public class ThreadPool {
    private static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        Runnable thr1 = new Threads("task 1");
        Runnable thr2 = new Threads("task 2");
        Runnable thr3 = new Threads("task 3");
        Runnable thr4 = new Threads("task 4");
        Runnable thr5 = new Threads("task 5");

        ExecutorService ex = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 6; i++) {
            ex.execute(thr1);
            ex.execute(thr2);
            ex.execute(thr3);
            ex.execute(thr4);
            ex.execute(thr5);
        }

        for (int i = 0; i < 10; i++) {
            Runnable thr = new Threads(new SimpleDateFormat("hh:mm:ss").format(new Date()) + " " + i);
            ex.execute(thr);
        }
    }
}
