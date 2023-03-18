package org.example;

public class Interrupt {
    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread");
            }
        }
    }
    public static void main(String[] args)   {
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.print(i*5 + " ");
        }
        thread.interrupt();
    }
}
