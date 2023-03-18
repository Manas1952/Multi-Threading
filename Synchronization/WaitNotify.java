package org.example.Synchronization;

class Notify1 extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " started");

            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Inside Notify1: " + Thread.currentThread().getName() + " notified");
        }
    }
}

class Notify2 extends Thread {
    Notify1 notify1;

    Notify2(Notify1 notify1) {
        this.notify1 = notify1;
    }

    @Override
    public void run() {
        synchronized (this.notify1) {
            System.out.println(Thread.currentThread().getName() + " started");
            try {
                this.notify1.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Inside Notify2: " + Thread.currentThread().getName() + " notified");
        }
    }
}

class Notify3 extends Thread {
    Notify1 notify1;

    Notify3(Notify1 notify1) {
        this.notify1 = notify1;
    }

    @Override
    public void run() {
        synchronized (this.notify1) {
            System.out.println(Thread.currentThread().getName() + " started");

            this.notify1.notify(); // here one of the two thread (Thread-1 or Thread-2) will be always in waiting state, so you can use notifyAll() to notify all remaining threads, and those threads will run in normal manner they used to.

            System.out.println("Inside Notify3: " + Thread.currentThread().getName() +  " notified");
        }
    }
}

public class WaitNotify {
    public static void main(String[] args) {
        Notify1 notify1 = new Notify1();
        Notify2 notify2 = new Notify2(notify1);
        Notify3 notify3 = new Notify3(notify1);

        Thread thread1 = new Thread(notify1, "Thread-1");
        Thread thread2 = new Thread(notify2, "Thread-2");
        Thread thread3 = new Thread(notify3, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
