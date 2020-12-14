package com.interview.demo.thread.concurrent;


import java.util.concurrent.CountDownLatch;

/**
 * 程序计数器
 * CountDownLatch
 * 一个任务A，它要等待其他4 个任务执行完毕之后才能执行，此时就可以利用CountDownLatch 来实现这种功能了。
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void runThead() {
        for (int k = 0; k < 4; k++) {
            int finalK = k;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("k=" + finalK + ";name=" + Thread.currentThread().getName());
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        runThead();
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName());
    }

}
