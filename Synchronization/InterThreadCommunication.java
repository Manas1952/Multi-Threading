package org.example.Synchronization;

class Customer {
    int balance;

    Customer(int balance) {
        this.balance = balance;
    }

    synchronized void withdraw(int amount) {
        System.out.println("withdrawing...");

        if (balance < amount) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("handled");
            }
        }
        balance -= amount;
        System.out.println("withdrawn");
    }

    synchronized void deposit(int amount) {
        System.out.println("Depositing...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("handled");
        }

        balance += amount;

        System.out.println("Deposited");
        notify();
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        Customer customer = new Customer(1000);

        new Thread(() -> customer.withdraw(2000)).start();

        new Thread() {
            @Override
            public void run() {
                customer.deposit(1000);
            }
        }.start();

    }
}
