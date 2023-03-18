package org.example.Methods;

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int iterator = 1; iterator < 5; iterator++) {
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException interruptedException) {
                System.out.println(interruptedException);
            }
            System.out.println(iterator + " Thread: " + Thread.currentThread().getName());
        }
    }
}

public class JoinWithTime {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        MyThread1 thread2 = new MyThread1();
        MyThread1 thread3 = new MyThread1();

        thread1.start();
        try {
            thread1.join(100);
        }
        catch (InterruptedException interruptedException) {
            System.out.println(interruptedException);
        }

        thread2.start();
        thread3.start();
    }
}
