package com.sandy;

/**
 * Created by sandy on 7/29/16.
 */
public class HeyThread {

    public static void main(String[] args) {
        new Thread(new CountDown(1000000), "thread-1").start();
        new Thread(new CountDown(1000000), "thread-2").start();
    }

}
