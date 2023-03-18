package org.example;

public class ExceptionCaught {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("inside newThread");

            throw new RuntimeException("intentional exception");
        });

        thread.setName("newThread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Critical exception due to " + t.getName() + ", and the error is " + e.getMessage());
            }
        });

        thread.start();
    }
}
