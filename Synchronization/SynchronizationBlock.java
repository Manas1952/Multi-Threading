package org.example.Synchronization;

class Table {
    void print(int number) {
        synchronized (this) {
            for (int iterator = 0; iterator < 10; iterator++) {
                System.out.println(Thread.currentThread().getName() + " - " + iterator * number);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

class MyThread extends Thread {
    Table table;

    MyThread(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        table.print(5);
    }
}

public class SynchronizationBlock {

    public static void main(String[] args) {
        Table table = new Table();

        MyThread thread1 = new MyThread(table);
        MyThread thread2 = new MyThread(table);

        thread1.start();
        thread2.start();
    }
}
