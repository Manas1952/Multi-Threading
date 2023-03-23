package org.example.Reentrant;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner {
    int count = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    void increment() {
        for (int iterator = 0; iterator < 10000; iterator++) {
            count++;
        }
        System.out.println("done increment() by , " + Thread.currentThread().getName() + " - " + count);
    }

    void firstThread() throws InterruptedException {

        lock.lock();

        System.out.println("Waiting...");
//        condition.await();
        Thread.sleep(10000);
        System.out.println("Woken up!");

        increment();
        lock.unlock();
    }

    void secondThread() throws InterruptedException {

        Thread.sleep(1000);
        lock.lock();

        System.out.println("press enter key!");
        new Scanner(System.in).nextLine();
        System.out.println("Gotcha!");

//        condition.signal();

        increment();

        lock.unlock();
    }

    void finished() {
        System.out.println("Count: " + count);
    }
}

public class Reentrant {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();

        Thread thread1 = new Thread() {

            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {

            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();

//        thread1.join();
//        thread2.join();

        runner.finished();
    }
}
