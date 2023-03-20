package org.example.Synchronization;

class Sender {

    void send(String message) {
        System.out.println(Thread.currentThread().getName() + " sending: " + message);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " sent the message: " + message);
    }
}

class SenderThread extends Thread {
    Sender sender;
    String message;

    SenderThread(Sender sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (sender) {
            sender.send(message);
        }
    }
}

public class SendersSync {
    public static void main(String[] args) {
        Sender sender = new Sender();

        SenderThread thread1 = new SenderThread(sender, "message-1");
        SenderThread thread2 = new SenderThread(sender, "message-2");


        try {
            thread1.start();
//            thread1.join();
            thread2.start();
//            thread2.join();
        } catch (Exception e) {
            System.out.println("handled");
        }
    }
}
