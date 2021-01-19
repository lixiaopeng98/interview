package com.interview.demo.thread.twotheardprint;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * @describe: test
 * @author: lxp
 * @date: 2021/1/4 10:38
 */
public class test {

    public static Object object = new Object();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> completableFuture = new CompletableFuture<String>();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                completableFuture.complete("aaa");
//            }
//        }).start();
//
//        String s = completableFuture.get();
//        System.out.println(s);
//        handleWait();


        String s = new String("[{\"conditions\":\"{\\\"groupName\\\":\\\"android\\\",\\\"type\\\":0,\\\"value\\\":[]}\",\"filterCode\n" +
                "\"ios\\\",\\\"type\\\":0,\\\"value\\\":[]}\",\"filterCode\":\"osVersion\",\"id\":829,\"opType\":\"OR\",\"order\":0},{\"conditions\":\"{\\\"groupName\\\":\\\"android\\\",\\\"gtValue\\\":999999,\\\"ltValue\\\":10000}\",\"filterCode\":\"appV\\\",\\\"gtValue\\\":999999,\\\"ltValue\\\":10000}\",\"filterCode\":\"appVersion\",\"id\":827,\"opType\":\"BTWN\",\"order\":0}]");
        JSONArray objects = JSONObject.parseArray(s);
        System.out.println(objects);
    }


    public static void handleWait() throws InterruptedException {
        synchronized (object){
            object.wait();
        }



    }

}
