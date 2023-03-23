package org.example;

class MyThread2 extends Thread {
    MyThread2(java.lang.ThreadGroup threadGroup, String groupName) {
        super(threadGroup , groupName);
        start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
//        for (int iterator = 0; iterator < 1000; iterator++) {
//            try {
//                sleep(10);
//            } catch (InterruptedException e) {
//                System.out.println("handled");
//            }
//        }
    }
}

public class ThreadGroup {
    public static void main(String[] args) {
        java.lang.ThreadGroup threadGroup = new java.lang.ThreadGroup("group1");

        System.out.println(Thread.currentThread());

        MyThread2 thread1 = new MyThread2(threadGroup, "thread1");
        MyThread2 thread2 = new MyThread2(threadGroup, "thread2");

        System.out.println(threadGroup.activeCount());
    }
}
