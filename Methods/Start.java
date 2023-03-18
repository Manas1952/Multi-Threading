package org.example.Methods;
class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
    }
}
public class Start {
    public static void main(String[] args) {
        MyThread2 thread = new MyThread2();
        thread.start();

        try {
            thread.start();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
