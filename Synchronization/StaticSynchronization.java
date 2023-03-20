package org.example.Synchronization;

class Table1 {
    synchronized static void print(int number) {
        for (int iterator = 0; iterator < 5; iterator++) {
            System.out.println(Thread.currentThread().getName() + " - " + iterator);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("handled");
            }
        }
    }
}
class MyThread2 extends Thread {
    int number;
    MyThread2(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        Table1.print(number);
    }
}

public class StaticSynchronization {
    public static void main(String[] args) {
        MyThread2 thread1 = new MyThread2(1);
        MyThread2 thread2 = new MyThread2(2);
        MyThread2 thread3 = new MyThread2(3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
