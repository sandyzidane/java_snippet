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

        for (int i = 0; i < QTY; i++) {
            String senderName = "sender-" + i;
            String receiverName = "receiver-" + i;
            Thread sender = new Thread(new Sender(data), senderName);
            Thread receiver = new Thread(new Receiver(data), receiverName);

            sender.start();
            receiver.start();
        }
    }
}

class Data {
    private String packet;
    private boolean transfer = true;

    public synchronized void send(String packet) {
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

    public synchronized String receive() {
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
        String[] packets = { "First", "Second", "Third", "Fourth", "Fifth", "END" };

        Arrays.stream(packets).forEach(packet -> {
            String tName = Thread.currentThread().getName();
            System.out.println(tName + " send: " + packet);

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
        String tName = Thread.currentThread().getName();
        do {
            receive = data.receive();
            System.out.println("receiver " + tName + " receive: " + receive);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!"END".equals(receive));
    }
}
