package org.example.Methods;

public class HoldsLock extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " acquiring lock: " + Thread.holdsLock(this));
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " acquiring lock: " + Thread.holdsLock(this));
        }
    }

    public static void main(String[] args) {
        HoldsLock thread = new HoldsLock();

        thread.start();
    }
}
