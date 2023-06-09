package org.example;

class StarvationDemo extends Thread {
    static int threadCount = 1;
    public void run()
    {
        System.out.println(Thread.currentThread().getName() + " - " + threadCount);
        threadCount++;
        System.out.println(Thread.currentThread().getName() + " execution completes");
    }
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Main thread execution starts");

        StarvationDemo thread1 = new StarvationDemo();
        thread1.setPriority(10);
        StarvationDemo thread2 = new StarvationDemo();
        thread2.setPriority(9);
        StarvationDemo thread3 = new StarvationDemo();
        thread3.setPriority(8);
        StarvationDemo thread4 = new StarvationDemo();
        thread4.setPriority(7);
        StarvationDemo thread5 = new StarvationDemo();
        thread5.setPriority(1);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Here thread5 have to wait because of the other thread. But after waiting for some interval, thread5 will get the chance of execution. It is known as Starvation
        thread5.start();

        System.out.println("Main thread execution completes");
    }
}