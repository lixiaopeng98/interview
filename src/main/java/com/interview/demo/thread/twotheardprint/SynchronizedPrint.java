package com.interview.demo.thread.twotheardprint;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @describe: 实现 两个线程相互打印 实现方案2
 * @author: lxp
 * @date: 2020/12/31 10:21
 */
public class SynchronizedPrint {

    /**
     * 使用 对象的 wait 和 notifyAll
     *
     * 1. wait 会释放持有的锁
     */
    public static Object obj = new Object();
    public static AtomicBoolean atomicBoolean = new AtomicBoolean();
    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static final int overInt = 100;


    private static void sol(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                while ( true){
                    synchronized ( obj){
                        while (atomicBoolean.get()){
                            try {
                                obj.wait();
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                        int i = atomicInteger.getAndIncrement();
                        System.out.println(thread.getName() + ":" + atomicInteger.get());
                        atomicBoolean.set(true);
                        obj.notifyAll();
                        if ( atomicInteger.get() > overInt ){
                            System.out.println(thread.getName() + ":" + atomicInteger.get() + ";超过100 退出");
                            return;
                        }
                    }
                }
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                while (true){
                    synchronized (obj){
                        if (!atomicBoolean.get()){
                            try {
                                obj.wait();
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                        int i = atomicInteger.getAndIncrement();
                        System.out.println(thread.getName() + ":" + atomicInteger.get());
                        atomicBoolean.set(false);
                        obj.notifyAll();
                        if (atomicInteger.get() > overInt){
                            System.out.println(thread.getName() + ":" + atomicInteger.get() + ";超过100 退出");
                            return;
                        }

                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        sol();
    }

}
