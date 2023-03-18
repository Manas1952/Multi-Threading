package org.example.ShutdownHook;

class MyThread extends  Thread {
    @Override
    public void run() {
        System.out.println("Shutdown Hook task completed");
    }
}

public class AddShutdownHook {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        runtime.addShutdownHook(new MyThread());

        System.out.println("Main Thread is sleeping, press Ctrl+C to exit");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
