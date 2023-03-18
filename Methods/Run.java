package org.example.Methods;

public class Run extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Run thread1 = new Run();
        Run thread2 = new Run();

        // no multi-threading
        thread1.run();
        thread2.run();
    }
}
