package com.interview.demo.thread.twotheardprint;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreSys {

    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static Semaphore semaphoreOne = new Semaphore(0);
    public static Semaphore semaphoreTwo = new Semaphore(1);
    public static Semaphore semaphoreThree = new Semaphore(-10);

    public static void testTwoThreadPrint(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        semaphoreOne.acquire();
                        int i = atomicInteger.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + ";i=" + i);
                        semaphoreTwo.release();
                        if ( atomicInteger.get() > 100){
                            return;
                        }
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        semaphoreTwo.acquire();
                        int i = atomicInteger.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + ";i=" + i);
                        semaphoreOne.release();
                        if ( atomicInteger.get() > 100){
                            return;
                        }
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }).start();
    }


    public static void testAAA(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                semaphoreThree.release();
                semaphoreThree.release();
                semaphoreThree.release();
                semaphoreThree.release();
                semaphoreThree.release();
                int i = semaphoreThree.drainPermits();
                System.out.println("可用的许可证为" + i);
            }
        }).start();
    }

    public static void main(String[] args) {
//        testTwoThreadPrint();


        testAAA();


        while ( Thread.activeCount() >= 2){
            Thread.yield();
        }
    }
}
