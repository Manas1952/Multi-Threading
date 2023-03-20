package org.example;

public class Volatile {
    public static volatile int counter = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int localVariable = 0;
                while (localVariable < 10) {
                    if (localVariable != counter){
                        localVariable = counter;
                        System.out.println("thread1 - " + counter);
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                int localVariable = 0;
                while (localVariable < 10) {
                    counter = ++localVariable;
                    System.out.println("thread2 - " + counter);

                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("handled");
                    }
                }
            }
        };

        thread1.start();
        thread2.start();

    }
}