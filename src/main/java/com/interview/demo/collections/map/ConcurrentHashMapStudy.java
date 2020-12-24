package com.interview.demo.collections.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 这玩意是 线程安全的
 * 分段锁 Segment  synchronized
 */
public class ConcurrentHashMapStudy {


    public static void testConcurrentHashMap(){
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("aaa", "aaa");
    }

}
