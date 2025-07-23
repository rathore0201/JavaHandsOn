package org.example.multithreading.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOFServices = 3;

        ExecutorService executors = Executors.newFixedThreadPool(numberOFServices);
        CountDownLatch latch = new CountDownLatch(numberOFServices);

        executors.submit(new DependentService(latch));
        executors.submit(new DependentService(latch));
        executors.submit(new DependentService(latch));

        latch.await(); // wait for all threads to complete before invoking main thread

        System.out.println("Main");
        executors.shutdown();
    }
}

class DependentService implements Callable<String> {
    CountDownLatch latch;
    DependentService(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public String call() throws Exception{
        try{
            System.out.println(Thread.currentThread().getName() + " started");
            Thread.sleep(2000);
        }finally {
            latch.countDown();
        }
        return "Ok";
    }
}
