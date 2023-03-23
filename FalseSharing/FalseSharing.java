package org.example.FalseSharing;

class Counter {
    public volatile long count1 = 0;
    public volatile long count2 = 0;
}

public class FalseSharing {
    public static void main(String[] args) {
        Counter counter1 = new Counter();

        // here false sharing will be done
//        Counter counter2 = counter1;

        Counter counter2 = new Counter();
        long iterations = 1_000_000_000;

        Thread thread1 = new Thread(() -> {
            long startTime = System.currentTimeMillis();

            for (int iterator = 0; iterator < iterations; iterator++) {
                counter1.count1++;
            }

            long endTime = System.currentTimeMillis();

            System.out.println("Time taken: " + (endTime - startTime));
        });

        Thread thread2 = new Thread(() -> {
            long startTime = System.currentTimeMillis();

            for (int iterator = 0; iterator < iterations; iterator++) {
                counter2.count2++;
            }

            long endTime = System.currentTimeMillis();

            System.out.println("Time taken: " + (endTime - startTime));
        });

        thread1.start();
        thread2.start();
    }
}
