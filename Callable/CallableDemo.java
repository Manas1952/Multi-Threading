package org.example.Callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        int delay = new Random().nextInt(5);

        Thread.sleep(delay * 1000);
        System.out.println(Thread.currentThread().getName() + " - " + delay);

        return delay;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask[] futureTasks = new FutureTask[5];

        for (int iterator = 0; iterator < 5; iterator++) {
            Callable callable = new MyCallable();

            futureTasks[iterator] = new FutureTask(callable);

            Thread thread = new Thread(futureTasks[iterator]);

            System.out.println(thread.getName() + " started");
            thread.start();
        }

        for (int iterator = 0; iterator < 5; iterator++) {
            System.out.println(futureTasks[iterator].get());
        }
    }
}