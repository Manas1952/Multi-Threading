package org.example.Methods;

public class Stop extends Thread {

    @Override
    public void run() {
        System.out.println("running");

        for (int iterator = 0; iterator < 4; iterator++) {
            try {
                sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " - " + iterator);
        }
    }

    public static void main(String[] args) {
        Stop thread1 = new Stop();
        Stop thread2 = new Stop();
        Stop thread3 = new Stop();

        thread1.start();
        thread2.start();

        thread3.start();
        thread3.stop();
    }
}
