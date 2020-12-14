package com.interview.demo.thread.callable;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.*;

public class TestCallable implements Callable {
    @Override
    public Object call() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaa", "aaa");
        jsonObject.put("name", "test");
        return jsonObject;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        TestCallable testCallable = new TestCallable();

        Future future = pool.submit(testCallable);

        System.out.println(future.get().toString());
        pool.shutdown();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5,
                20,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        Future submit = poolExecutor.submit(testCallable);
        System.out.println(submit.get().toString());
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        Thread.currentThread().interrupt();
        Thread.currentThread().isInterrupted();
    }
}
