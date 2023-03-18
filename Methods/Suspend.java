package org.example.Methods;

public class Suspend extends Thread {
    @Override
    public void run() {
        for (int iterator = 0; iterator < 4; iterator++) {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " - " + iterator);
        }
    }
    public static void main(String[] args) {
        Suspend thread1 = new Suspend();
        Suspend thread2 = new Suspend();
        Suspend thread3 = new Suspend();

        thread1.start();

        thread2.start();
        thread2.suspend();

        thread3.start();
        thread2.resume();
    }
}
