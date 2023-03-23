package org.example.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {
    String message;
    WorkerThread (String message) {
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started with message: " + message);

        // mimicking doing heavy process
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("handled");
        }

        System.out.println(Thread.currentThread().getName() + " ended");
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int iterator = 0; iterator < 10; iterator++) {
            executorService.execute(new WorkerThread("" + iterator));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            // main thread working...
        }

        System.out.println("\nFinished all threads");
    }
}
