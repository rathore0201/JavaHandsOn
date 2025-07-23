package org.example.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private Lock lock = new ReentrantLock();

    public  void outerMethod(){
        lock.lock();
        try {
            System.out.println("Outer method");
            innerMethod();
        }finally {
            System.out.println("Unlock outer");
            lock.unlock();
        }
    }

    public  void innerMethod(){
        lock.lock(); // Ideally it should wait for the previous lock to unlock before acquiring it and leads to deadlock. but Reentrant for the same thread allows multiple times to gain the lock and note the count of it to unlock
        try {
            System.out.println("Inner method");
        }finally {
            System.out.println("Unlock inner");
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample lockExample = new ReentrantLockExample();
        lockExample.outerMethod();
    }
}
