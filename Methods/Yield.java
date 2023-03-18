package org.example.Methods;

public class Yield extends Thread {
    @Override
    public void run() {
        for (int iterator = 0; iterator < 3; iterator++) {
            System.out.println(Thread.currentThread().getName() + " in control");
        }
    }
    public static void main(String[] args) {
        Yield thread1 = new Yield();
        Yield thread2 = new Yield();

        thread1.start();
        thread2.start();

        for (int iterator = 0; iterator < 3; iterator++) {
//            Thread.yield();
            thread1.yield();
            System.out.println(Thread.currentThread().getName() + " in control.");
        }
    }
}
