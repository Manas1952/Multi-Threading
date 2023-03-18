package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PoliceHacker {
    private static final int MAX_PASSWORD = 9999;

    private static class Vault {
        private int password;

        Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guess) {
            try {
                Thread.sleep(5);
            }
            catch (InterruptedException interruptedException) {

            }
            return guess == password;
        }
    }

    private static abstract  class HackerThread extends Thread{
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("starting thread: " + this.getName());
            super.start();
        }
    }

    private static class AscThread extends HackerThread {

        AscThread(Vault vault) {
            super(vault);
        }
        @Override
        public void start() {
            super.start();
        }

        @Override
        public void run() {
            for (int iterator = 0; iterator <= MAX_PASSWORD; iterator++) {
                if (vault.isCorrectPassword(iterator)) {
                    System.out.println("guessed by AscThread: " + iterator);
                    System.exit(0);
                }
            }
        }
    }

    private static class DscThread extends HackerThread {

        DscThread(Vault vault) {
            super(vault);
        }
        @Override
        public void start() {
            super.start();
        }

        @Override
        public void run() {
            for (int iterator = MAX_PASSWORD; iterator > 0; iterator--) {
                if (vault.isCorrectPassword(iterator)) {
                    System.out.println("guessed by DscThread: " + iterator);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread{
        @Override
        public void run() {
            for (int iterator = 0; iterator < 10; iterator++) {
                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException interruptedException) {

                }
                System.out.println(iterator);
            }
            System.out.println("Game Over");
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        Random random = new Random();

        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

        List<Thread> list = new ArrayList<>();

        list.add(new AscThread(vault));
        list.add(new DscThread(vault));
        list.add(new PoliceThread());

        for (Thread thread: list) {
            thread.start();
        }
    }
}