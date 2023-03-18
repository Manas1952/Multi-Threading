package org.example.Methods;

public class DumpStack {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        System.out.println("current thread: " + thread);

        System.out.println(Thread.activeCount());

        Thread.dumpStack();
    }
}
