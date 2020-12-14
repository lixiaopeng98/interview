package com.interview.demo.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Semaphore
 *
 * Semaphore 翻译成字面意思为 信号量，Semaphore 可以控制同时访问的线程个数，通过
 * acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
 * Semaphore 类中比较重要的几个方法：
 * 1. public void acquire(): 用来获取一个许可，若无许可能够获得，则会一直等待，直到获得许可。
 * 2. public void acquire(int permits):获取permits 个许可
 * 3. public void release() { } :释放许可。注意，在释放许可之前，必须先获获得许可。
 * 4. public void release(int permits) { }:释放permits 个许可
 * 上面4 个方法都会被阻塞，如果想立即得到执行结果，可以使用下面几个方法
 * 1. public boolean tryAcquire():尝试获取一个许可，若获取成功，则立即返回true，若获取失败，则立即返回false
 * 2. public boolean tryAcquire(long timeout, TimeUnit unit):尝试获取一个许可，若在指定的时间内获取成功，则立即返回true，否则则立即返回false
 * 3. public boolean tryAcquire(int permits):尝试获取permits 个许可，若获取成功，则立即返回true，若获取失败，则立即返回false
 * 4. public boolean tryAcquire(int permits, long timeout, TimeUnit unit): 尝试获取permits个许可，若在指定的时间内获取成功，则立即返回true，否则则立即返回false
 * 5. 还可以通过availablePermits()方法得到可用的许可数目。
 * 例子：若一个工厂有5 台机器，但是有8 个工人，一台机器同时只能被一个工人使用，只有使用完
 * 了，其他工人才能继续使用。那么我们就可以通过Semaphore 来实现：
 */
public class SemaphoreTest {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    private static Semaphore semaphore = new Semaphore(4);

    public static void runTest(){

        for (int k = 0; k < 10; k++) {
            int finalK = k;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("k=" + finalK + "; 进来了 准备开始获取令牌:");
                        cyclicBarrier.await();
                        System.out.println("k=" + finalK + "; 被唤醒:");
                        semaphore.acquire();
                        System.out.println("k=" + finalK + "; 获取到了令牌:");
                        semaphore.release();
                        System.out.println("k=" + finalK + "; 释放了令牌:");
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
        System.out.println("main 调用完函数了");
        while (Thread.activeCount() > 1){
            Thread.yield();
            System.out.println("aaa");
        }
        System.out.println("main 真正的执行完了 ");
    }
}
