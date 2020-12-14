package com.interview.demo.atomic;


import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {

    private static int DEFAULT_NUM = 10;

    private static int DEFAULT_FOR_NUM = 100;

    private static volatile int DEFAULT_ADD_NUM = 0;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void testAtomic(){
        atomicInteger.incrementAndGet();
//        DEFAULT_ADD_NUM ++;
    }

    public static void threadAdd(){
        Thread[] threads = new Thread[DEFAULT_NUM];
        for (int k = 0; k < DEFAULT_NUM; k++) {
            threads[k] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int c = 0; c < DEFAULT_FOR_NUM; c++) {
                        testAtomic();
                    }
                    System.out.println(atomicInteger.get());
                    System.out.println(Thread.currentThread().getName() + "=" + DEFAULT_ADD_NUM);
                }
            });
            threads[k].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("atomicInteger=" + atomicInteger.get());
        System.out.println("DEFAULT_ADD_NUM=" + DEFAULT_ADD_NUM);
    }

    public static void main(String[] args) {
        threadAdd();
    }

}
