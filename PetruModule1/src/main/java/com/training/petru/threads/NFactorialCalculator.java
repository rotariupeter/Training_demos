package com.training.petru.threads;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class NFactorialCalculator implements Callable<BigInteger> {

    private int no;
    private  BigInteger result;

    public NFactorialCalculator(int no) {
        this.no = no;
    }

    public BigInteger getResult() {
        return result;
    }
    @Override
    public BigInteger call() throws Exception {
        return calculateFactorial(no);
    }

    private BigInteger calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }

        result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            try {
                System.out.println("sleep "+i);
                Thread.sleep(1);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result = result.multiply(new BigInteger(""+i));
        }
        return result;

    }
}