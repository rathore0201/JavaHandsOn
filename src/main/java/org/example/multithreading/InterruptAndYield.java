package org.example.multithreading;

public class InterruptAndYield extends Thread {

    @Override
    public void run() {
//        try {
//            Thread.sleep(10000);
//            System.out.println("Thread is running .... ");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        for (int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName());
            Thread.yield(); // It gives priority to other threads just a hint not strict
        }
    }
}

//op with yield :
//Thread-1
//Thread-0
//Thread-1
//Thread-0
//Thread-1
//Thread-0
//Thread-0
//Thread-1
//Thread-0
//Thread-1

//op without yield :
//Thread-0
//Thread-0
//Thread-0
//Thread-0
//Thread-0
//Thread-1
//Thread-1
//Thread-1
//Thread-1
//Thread-1
