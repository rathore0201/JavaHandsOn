package org.example.multithreading.executors;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {
        int numberOFServices = 3;

        ExecutorService executors = Executors.newFixedThreadPool(numberOFServices);

        CyclicBarrier barrier = new CyclicBarrier(numberOFServices);
        executors.submit(new DependentService1(barrier));
        executors.submit(new DependentService1(barrier));
        executors.submit(new DependentService1(barrier));

        System.out.println("Main");
        barrier.reset();
    }
}

class DependentService1 implements Callable<String> {
    CyclicBarrier barrier;
    DependentService1(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception{
            System.out.println(Thread.currentThread().getName() + " started");
            Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");
        barrier.await();
        return "Ok";
    }
}
