package org.example.Methods.GC;

public class GC {
    @Override
    // no guarantee
    public void finalize() {
        System.out.println("finalize()");
    }

    public static void main(String[] args) {
        GC object1 = new GC();
        GC object2 = new GC();

        object1 = null;
        object2 = null;

        System.gc();
    }
}
