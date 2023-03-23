package org.example.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    BlockingQueue queue = null;

    Producer (BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(1);
            Thread.sleep(200);
            queue.put(2);
            Thread.sleep(200);
            queue.put(3);
            queue.put(4);
        } catch (InterruptedException e) {
            System.out.println("handled");
        }
    }
}

class Consumer implements Runnable {
    BlockingQueue queue = null;

    Consumer (BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            Thread.sleep(200);
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            System.out.println("handled");
        }
    }
}

public class ArrayBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue queue = new java.util.concurrent.ArrayBlockingQueue(2);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

