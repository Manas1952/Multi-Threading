package org.example.ShutdownHook;

class MyThread1 extends  Thread {
    @Override
    public void run() {
        System.out.println("Shutdown Hook task completed " + Thread.currentThread().getName());
    }
}

public class RemoveShutdownHook {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        MyThread1 thread2 = new MyThread1();
        MyThread1 thread3 = new MyThread1();

        Runtime.getRuntime().addShutdownHook(thread1);
        Runtime.getRuntime().addShutdownHook(thread2);
        Runtime.getRuntime().addShutdownHook(thread3);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Runtime.getRuntime().removeShutdownHook(thread1);

        System.out.println("Main terminating");
    }
}