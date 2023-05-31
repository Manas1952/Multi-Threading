package org.example.Deadlock;

class Student {
    String name = "default";
}

public class Deadlock {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        Thread thread1 = new Thread("MyThread1") {
            @Override
            public void run() {
                synchronized (student1) {
                    System.out.println("Thread1 resource1 locked!");

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    student2.name = "Manas";

                    System.out.println("Thread1, s1: " + student1.name);
                    System.out.println("Thread1, s2: " + student2.name);

                    synchronized (student2) {
                        System.out.println("Thread1 resource2 locked!");
                    }
                }
            }
        };

        Thread thread2 = new Thread("MyThread2"){
            @Override
            public void run() {
                synchronized (student2) {
                    System.out.println("Thread2 resource2 locked!");

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    student1.name = "Aryan";

                    System.out.println("Thread2, s1: " + student1.name);
                    System.out.println("Thread2, s2: " + student2.name);

                    synchronized (student1) {
                        System.out.println("Thread2 resource1 locked!");
                    }
                }
            }
        };

        thread1.start();


        // handling deadlock

//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            System.out.println("handled");
//        }
        thread2.start();
    }
}
