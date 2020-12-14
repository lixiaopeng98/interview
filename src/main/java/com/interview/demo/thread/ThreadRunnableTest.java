package com.interview.demo.thread;

public class ThreadRunnableTest implements Runnable {

    public static int cc = 10;

    public ThreadRunnableTest(int cc) {
        this.cc = cc;
    }

    @Override
    public void run() {
        try {
            Thread.sleep( 5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cc);
    }
}
