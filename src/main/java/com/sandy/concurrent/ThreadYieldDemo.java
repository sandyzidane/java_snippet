package com.sandy.concurrent;

public class ThreadYieldDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("Hello from new thread"), "new Thread");

        t.start();

        Thread.yield(); //main thread yield
        //Thread.sleep(1); //main thread sleep

        System.out.println("Hello from main thread");

        t.join();
    }
    
}