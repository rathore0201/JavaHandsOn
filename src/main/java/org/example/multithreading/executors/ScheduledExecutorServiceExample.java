package org.example.multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(
                () -> System.out.println("Task executed after 5 sec delay.. !"),
                5,
                TimeUnit.SECONDS
        );
        scheduledExecutorService.shutdown();


        // This will not work until you handle when to stop this scheduler
        scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println("Task executed after every 5 sec delay.. !"),
                5,
                5,
                TimeUnit.SECONDS
        );

        scheduledExecutorService.schedule(()-> {
            System.out.println("Initiating shutdown.. !");
            scheduledExecutorService.shutdown();
        }, 20, TimeUnit.SECONDS);
    }
}
