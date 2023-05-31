package org.example.CountDownLatch;

class Worker extends Thread {
    private int delay;
    private java.util.concurrent.CountDownLatch countDownLatch;

    public Worker (int delay, java.util.concurrent.CountDownLatch countDownLatch, String name) {
        super(name);
        this.delay = delay;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "");
            Thread.sleep(delay);
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + " finished");
        } catch (Exception e) {
            System.out.println("handled");
        }
    }
}

public class CountDownLatch {
    public static void main(String[] args) {
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(2);

        Thread thread1 = new Thread(new Worker(1000, countDownLatch, "thread1"));
        Thread thread2 = new Thread(new Worker(2000, countDownLatch, "thread2"));
        Thread thread3 = new Thread(new Worker(3000, countDownLatch, "thread3"));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println("handled");
        }

        System.out.println("main thread completed execution");
    }
}