package org.example.Methods;

class MyThread4 extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("handled");
            }

            System.out.println(Thread.currentThread().getName() + " running");

            for (int iterator = 1; iterator <= 10; iterator++) {
                total += iterator;
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("handled");
            }

            notify();
        }
    }
}

public class Notify {
    public static void main(String[] args) {
        MyThread4 thread = new MyThread4();

        thread.start();

        synchronized (thread) {
            try {
                System.out.println("Waiting for thread to complete");

                thread.wait(); // main-thread will release lock and Thread-0 acquire lock.
            }
            catch (InterruptedException ie) {
                System.out.println("handled");
            }
            System.out.println("Total: " + thread.total);
        }
    }
}
