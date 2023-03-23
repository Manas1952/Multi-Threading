package org.example.ThreadLocal;

class MyRunnable implements Runnable {
    private java.lang.ThreadLocal<Integer> threadLocal = new java.lang.ThreadLocal<>();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadLocal.get());
    }
}

public class ThreadLocal {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
