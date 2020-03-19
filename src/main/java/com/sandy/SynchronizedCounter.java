package com.sandy;

/**
 * Created by sandy on 7/29/16.
 */
public class SynchronizedCounter {

    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();
        Thread t1 = new Thread(() -> {
            for (int i=0; i<10000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i=0; i<9999; i++) {
                counter.decrement();
            }
        });
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
            System.out.println("now counter c's value is " + counter.value());
        }

    }
}
