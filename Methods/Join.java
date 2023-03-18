package org.example.Methods;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int iterator = 1; iterator < 5; iterator++) {
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException interruptedException) {
                System.out.println(interruptedException);
            }
            System.out.println(Thread.currentThread().getName() + " - " + iterator);
        }
    }
}

public class Join {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        thread1.start();
        try {
            thread1.join();
        }
        catch (InterruptedException interruptedException) {
            System.out.println(interruptedException);
        }

        thread2.start();
        thread3.start();
    }
}
