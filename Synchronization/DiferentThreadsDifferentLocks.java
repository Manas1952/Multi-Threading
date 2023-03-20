package org.example.Synchronization;

class MyThread1 extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            for (int iterator = 0; iterator < 2; iterator++) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " - " + iterator);
            }
        }
    }
}

public class DiferentThreadsDifferentLocks {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        MyThread1 thread2 = new MyThread1();
        MyThread1 thread3 = new MyThread1();
        MyThread1 thread4 = new MyThread1();

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread4.start();
        try {
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
