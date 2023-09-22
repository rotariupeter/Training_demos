package com.training.petru.threads;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadIntreruptionAfterAWhile {

    public static void main(String[] args) {

        int n=111;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        NFactorialCalculator factorialCalculator = new NFactorialCalculator(n);

        Future<BigInteger> result = executorService.submit(factorialCalculator);

        //this thread monitoring the above thread: scheduleAtFixedRate executes each 10 milis to get value of the factorialCalculator
        //if thread is done every thing is fine but if is not done after 100 milis the thread will be closed and timeout...
        ScheduledExecutorService monitoringExecutor = Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture<?> timeoutFuture = monitoringExecutor.schedule(() -> {
            if (!result.isDone()) {
                result.cancel(true); // Cancel the calculation in 100 mils if it's not done
                System.out.println("Timeout");
            }
            monitoringExecutor.shutdown(); // Shutdown the monitoring thread
        }, 100, TimeUnit.MILLISECONDS);

        monitoringExecutor.scheduleAtFixedRate(() -> {
            if (!result.isDone()) {
                BigInteger intermediateResult = factorialCalculator.getResult();
                System.out.println("Intermediate result: " + intermediateResult);
            } else {
                BigInteger finalResult = factorialCalculator.getResult();
                System.out.println("Factorial result: " + finalResult);
                timeoutFuture.cancel(false);
                monitoringExecutor.shutdown(); // Shutdown the monitoring thread
            }
        }, 0, 10, TimeUnit.MILLISECONDS);
        executorService.shutdown();

        //here is the simple implementation with only interruption after a while
//        try {
//            BigInteger aLong = result.get(11, TimeUnit.MILLISECONDS);
//            System.out.println("Factorial of " + n + " is: " + aLong);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        } catch (TimeoutException e) {
//            System.out.println("Time Out on execution of the method");
//        }
    }
}
