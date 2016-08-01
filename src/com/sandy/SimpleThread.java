package com.sandy;

/**
 * Created by sandy on 7/29/16.
 */
public class SimpleThread {

    static void message(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s\n", threadName, message);
    }

    private static class MeesageLoop implements Runnable {
        public void run() {
            String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
            };

            for (int i=0; i<importantInfo.length; i++) {
                try {
                    Thread.sleep(4000);
                    message(importantInfo[i]);
                }
                catch (InterruptedException e) {
                    message("I wasn't done yet");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        long patience = 1000 * 60 * 60;

        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            }
            catch (NumberFormatException e) {
                System.err.println("Argument must be Integer");
                System.exit(1);
            }
        }

        message("Start MessageLoop");
        long start = System.currentTimeMillis();
        Thread t = new Thread(new MeesageLoop());
        t.start();

        message("Wait messageLoop to finish");
        while (t.isAlive()) {
            message("Still waiting");
            t.join(1000);
            if (((System.currentTimeMillis() - start) > patience ) && t.isAlive()) {
                message("tired of waiting");
                t.interrupt();
                t.join();
            }
        }
        message("Finally");

    }
}
