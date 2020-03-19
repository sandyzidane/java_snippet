package com.sandy.concurrent;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description
 */
public class WaitAndNotifyDemo {

    private static final int QTY = 10;

    public static void main(String[] args) {
        Data data = new Data();

        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}

class Data {
    private String packet;
    private boolean transfer = true;

    public void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        transfer = false;
        this.packet = packet;
        notifyAll();
    }

    public String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }
}

class Sender implements Runnable {
    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String[] packets = {
                "First",
                "Second",
                "Third",
                "Fourth",
                "Fifth",
                "END"
        };

        Arrays.stream(packets)
                .forEach(packet -> {
                    data.send(packet);

                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
    }
}

class Receiver implements Runnable {
    private Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String receive;
        do {
            receive = data.receive();
            System.out.println("receive: " + receive);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!"END".equals(receive));
    }
}
