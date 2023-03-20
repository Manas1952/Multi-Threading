package org.example.Synchronization;

class Data {
    private String data;
    private boolean transfer = true;

    synchronized void send(String packet) {
        while (!transfer) {
            try {
                System.out.println("send() in waiting...");
                wait();
                System.out.println("send() continuing...");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("interrupted");
            }
        }

        transfer = false;

        this.data = packet;
        notifyAll();
    }

    synchronized String receive() {
        while (transfer) {
            try {
                System.out.println("receive() in waiting...");
                wait();
                System.out.println("receive() continuing...");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("interrupted!");
            }

        }
        transfer = true;
        notifyAll();

        return data;
    }
}

class SenderThread1 implements Runnable {
    private Data data;

    SenderThread1(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String packets[] = {"p1", "p2", "p3", "p4", "end"};

        for (String packet : packets) {
            data.send(packet);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("interrupted!!");
            }
        }
    }
}

class ReceiverThread1 implements Runnable {
    private Data data;

    ReceiverThread1 (Data data) {
        this.data = data;
    }

    @Override
    public void run() {

        for (String receivedPacket = data.receive(); !"end".equals(receivedPacket); receivedPacket = data.receive()) {
            System.out.println("-> " + receivedPacket);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("interrupted!!");
            }
        }

    }
}

public class SenderReceiver {
    public static void main(String[] args) {
        Data data = new Data();
        Thread senderThread = new Thread(new SenderThread1(data));
        Thread receiverThread = new Thread(new ReceiverThread1(data));

        senderThread.start();
        receiverThread.start();
    }
}