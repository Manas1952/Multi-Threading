package org.example.Methods;

public class Interrupted extends Thread {
    @Override
    public void run() {
        for (int iterator = 0; iterator < 4; iterator++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("handled");
            }
            System.out.println(Thread.currentThread().getName() + " - " + iterator);
        }
    }

    public static void main(String[] args) {
        Interrupted thread1 = new Interrupted();
        Interrupted thread2 = new Interrupted();

        thread1.start();
        thread2.start();

        thread1.interrupt();
//        System.out.println(thread1.interrupted());
    }

}
