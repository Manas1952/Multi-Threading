package org.example.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class ReusingCB
{
    public static void main(String args[])
    {
        CyclicBarrier cb = new CyclicBarrier(3, new AfterAction1());

        Thread t1 = new Thread(new TxtReader1("T-1", "demo1", cb));
        Thread t2 = new Thread(new TxtReader1("T-2", "demo2", cb));
        Thread t3 = new Thread(new TxtReader1("T-3", "demo3", cb));

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Start another set of threads ");

        Thread t4 = new Thread(new TxtReader1("T-4", "demo4", cb));
        Thread t5 = new Thread(new TxtReader1("T-5", "demo5", cb));
        Thread t6 = new Thread(new TxtReader1("T-6", "demo6", cb));

        t4.start();
        t5.start();
        t6.start();
    }
}
class TxtReader1 implements Runnable
{
    private String threadName;
    private String fileName;
    private CyclicBarrier cb;

    TxtReader1(String threadName, String fileName, CyclicBarrier cb)
    {
        this.threadName = threadName;
        this.fileName = fileName;
        this.cb = cb;
    }
    @Override
    public void run()
    {
        System.out.println("Reading file " + fileName + " thread " + threadName);
        try
        {
            cb.await();
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
        catch (BrokenBarrierException e)
        {
            System.out.println(e);
        }
    }
}
class AfterAction1 implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("In after action class, start further processing as all files are read");
    }
}
