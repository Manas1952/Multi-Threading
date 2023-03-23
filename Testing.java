package org.example;

class Student {
    String name;

    Student (String name) {
        this.name = name;
    }

    synchronized void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + name);
        }
    }
}

class MyThread1 extends Thread {
    Student student;
    MyThread1 (Student student) {
        this.student = student;
    }
    @Override
    public void run() {
        student.print();
    }

    public static void main(String[] args) {
        Student student = new Student("Manas");
        System.out.println(Runtime.getRuntime().availableProcessors());
        MyThread1 thread1 = new MyThread1(student);
        MyThread1 thread2 = new MyThread1(student);

        thread1.start();
        thread2.start();
    }
}