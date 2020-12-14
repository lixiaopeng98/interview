package com.interview.demo.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable2 implements Callable {


    @Override
    public Object call() throws Exception {
        long l = System.currentTimeMillis();
        int k = 0;
        int a = 10000;
        for (int i = 0; i < a; i++) {
            k++;
        }
        System.out.println("访问 线程打印数据：" + Thread.currentThread().getName());
        System.out.println("访问 返回毫秒= " + (System.currentTimeMillis() - l));
        return "aa";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long l = System.currentTimeMillis();
        FutureTask futureTask = new FutureTask<>(new TestCallable2());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("线程 返回数据 执行完毕 打印数据：" + futureTask.get().toString());
        System.out.println("线程 返回数据 毫秒：" + (System.currentTimeMillis() - l));
    }
}
