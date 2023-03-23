package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVar {
    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    int get() {
        return atomicInteger.get();
    }

    void increment() {
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) {
        AtomicVar atomicVar = new AtomicVar();

        System.out.println(atomicVar.get());

        atomicVar.increment();

        System.out.println(atomicVar.get());
    }
}
