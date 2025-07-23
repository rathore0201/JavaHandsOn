package org.example.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class ExplicitLocking {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withDraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        while (true){
            try{
                if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){ // wait for 10 sec to acquire the lock
                    if(balance >= amount){
                        try{
                            System.out.println(Thread.currentThread().getName() + " proceeding to withdraw " + amount);
                            Thread.sleep(3000); // release lock after 3 seconds to be acquired by other thread after hat
                            balance -= amount;
                            System.out.println(Thread.currentThread().getName() + " successfully withdraw.....");
                        }catch (Exception e) {
                            System.out.println(Thread.currentThread().getName() + "Something wrong....");
                            Thread.currentThread().interrupt(); // This is to tell that something went wrong and thread gor interrupted
                        }finally {
                            lock.unlock();
                        }
                    }else {
                        lock.unlock();
                        System.out.println(Thread.currentThread().getName() + "Insufficient Balance");
                    }
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName() + " could not acquire the lock, try again later....");
                }
            }catch (Exception e){
                System.out.println("Something went wrong....");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExplicitLocking obj = new ExplicitLocking();

        Thread t1 = new Thread(() -> {
            obj.withDraw(50);
        });

        Thread t2 = new Thread(() -> {
            obj.withDraw(50);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
