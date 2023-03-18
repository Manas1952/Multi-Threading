package org.example;

import java.math.BigInteger;

public class LongComputation {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("200000000"), new BigInteger("3000000")));

        thread.start();
        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
        @Override
        public void run() {
                System.out.println("result: " + pow(base, power));
            System.out.println(Thread.currentThread().getState());
        }

        public BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                System.out.println(Thread.currentThread().getState());
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getState());
                    System.out.println("Premature exiting...");
                    System.out.println(Thread.currentThread().getState());
                    return BigInteger.ZERO;
                }

                result = result.multiply(base);
            }
            return result;
        }
    }
}
