package com.interview.demo.thread.twotheardprint;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @describe: test
 * @author: lxp
 * @date: 2021/1/4 10:38
 */
public class test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                completableFuture.complete("aaa");
            }
        }).start();

        String s = completableFuture.get();
        System.out.println(s);
    }

}
