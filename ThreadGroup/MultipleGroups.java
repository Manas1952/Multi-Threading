package org.example.ThreadGroup;

class MyThread extends Thread {
    MyThread(java.lang.ThreadGroup threadGroup, String threadName) {
        super(threadGroup, threadName);
        start();
    }

    @Override
    public void run() {
        for (int iterator = 0; iterator < 10; iterator++) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println("handled");
            }
        }
        System.out.println("finished");
    }
}
public class MultipleGroups {
    public static void main(String[] args) {
        java.lang.ThreadGroup parentGroup = new java.lang.ThreadGroup("parentGroup");
        java.lang.ThreadGroup childGroup = new java.lang.ThreadGroup("childGroup");

        MyThread thread1 = new MyThread(parentGroup, "thread1");
        MyThread thread2 = new MyThread(childGroup, "thread2");
        System.out.println(parentGroup.activeGroupCount());

    }
}
