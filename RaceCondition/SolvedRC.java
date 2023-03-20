package org.example.RaceCondition;

class Counter1 implements Runnable {
    private int count = 0;

    void increment() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("handled");
        }
        count++;
    }

    void decrement() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("handled");
        }
        count--;
    }

    int getCounter() {
        return count;
    }

    @Override
    synchronized public void run() {
        this.increment();
        System.out.println(Thread.currentThread().getName() + " - " + this.getCounter());

        this.decrement();
        System.out.println(Thread.currentThread().getName() + " - " + this.getCounter());
    }
}

public class SolvedRC {
    public static void main(String[] args) {
        Counter1 counter = new Counter1();

        Thread thread1 = new Thread(counter);
        Thread thread2 = new Thread(counter);
        Thread thread3 = new Thread(counter);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
