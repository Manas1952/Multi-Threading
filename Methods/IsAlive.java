package org.example.Methods;

class MyThread3 extends Thread {
    @Override
    public void run() {
        System.out.println("running...");
    }
}

public class IsAlive {
    public static void main(String[] args) {
        MyThread3 thread = new MyThread3();

        System.out.println(thread.isAlive());
        thread.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(thread.isAlive());
    }
}
