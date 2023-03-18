package org.example.Methods;

public class DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().isDaemon());
    }

    public static void main(String[] args) {
        DaemonThread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();
    }
}
