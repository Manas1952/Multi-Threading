package org.example.Methods;

public class IsInterrupted extends Thread {
    @Override
    public void run() {
        try {
//            sleep(500);
            System.out.println("nothing");
        } catch (Exception e) {
            System.out.println("handled");
        }
    }

    public static void main(String[] args) {
        IsInterrupted thread = new IsInterrupted();

        thread.start();
        thread.interrupt();

        System.out.println(thread.isInterrupted());
    }
}
