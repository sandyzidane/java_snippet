package com.sandy;

/**
 * 计数
 */
public class CountDown implements Runnable{

    private long howManyCount;

    public CountDown(long l) {
        this.howManyCount = l;
    }

    @Override
    public void run() {
        while(howManyCount > 0) {
            howManyCount--;
            System.out.println(howManyCount);
        }
    }
}
