package com.training.petru;

public class Main {

    public static int count = 0;

    public static synchronized void  incrementCounter(){
        synchronized (Main.class) {
            int current = count;

            System.out.println("Before: " + count + " Current thread: " + Thread.currentThread().getId());
            count++;// current+1;
            System.out.println("After: " + count + " Current thread: " + Thread.currentThread().getId());
        }
    }
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
           new Thread(() -> incrementCounter()).start();
        }
    }
}
