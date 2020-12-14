package com.interview.demo.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier（回环栅栏-等待至barrier 状态再全部同时执行）
 *
 * 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。叫做回环
 * 是因为当所有等待线程都被释放以后，CyclicBarrier 可以被重用。我们暂且把这个状态就叫做
 * barrier，当调用await()方法之后，线程就处于barrier 了。
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    public static void runTest(){
        for (int k = 0; k < 10; k++) {
            int finalK = k;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("k=" + finalK +";name=" + Thread.currentThread().getName() + "准备就绪;");
                        cyclicBarrier.await();
                        System.out.println("k=" + finalK +";name=" + Thread.currentThread().getName() + "执行完成;");
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        runTest();
        System.out.println("main调完函数!");
        while (cyclicBarrier.isBroken()){
            Thread.yield();
        }
        System.out.println("主线程真正执行完毕");
    }
}
