package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside new thread..." + Thread.currentThread().getName());
            }
        });

//        thread.setName("newThread");
//        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Inside " + Thread.currentThread().getName() + " thread before starting new thread");

        thread.start();

        System.out.println("Inside " + Thread.currentThread().getName() + " thread after starting new thread");

    }
}