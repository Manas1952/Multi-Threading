package org.example;

public class Thread2 {
    public static void main(String[] args) {
        Thread thread = new NewThread();

        thread.start();
    }
}

class NewThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from: " + this.getName());
    }
}
