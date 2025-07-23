package org.example.multithreading.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureAndCallable {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            return 1; //Callable's call() method return some value;
        };

        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            return 2; //Callable's call() method return some value;
        };

        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            return 3; //Callable's call() method return some value;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);

        List<Future<Integer>> futures = null;

        try {
            futures = executorService.invokeAll(list);
        } catch (InterruptedException e) {

        }

        for(Future<Integer> f : futures){
            try {
                System.out.println(f.get());
            }catch (InterruptedException | ExecutionException e){

            }
        }

        executorService.shutdown();
    }
}
