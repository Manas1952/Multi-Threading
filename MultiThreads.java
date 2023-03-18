package org.example;

class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread running... ");
    }
}

public class MultiThreads {
    public static void main(String[] args) {
        MyThread m = new MyThread();
        Thread thread = new Thread(m);
        thread.run();
    }
}
