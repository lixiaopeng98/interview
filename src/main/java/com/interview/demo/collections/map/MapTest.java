package com.interview.demo.collections.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class MapTest {

    public void testMap(){
        // 线程 不安全
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("aaa","aaa");
    }
    public void testConcurrentHashMap(){
        // Segment 槽 extent ReentrantLock 不会扩容
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("aaa","aaa");

        new ReentrantLock();
    }

    public void hashTable(){
        // synchronized 建议不要使用
        Hashtable<String, Object> hashtable = new Hashtable<>();
        hashtable.put("aaa","aaa");
    }

    public static void testMapOne(){
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("aab","kkk");
        treeMap.put("aaa","kkk");
        treeMap.put("ccc","kkk");
        treeMap.put("bbb","kkk");
        treeMap.keySet().stream().forEach(item -> {
            System.out.println(item + "=" + treeMap.get(item));
        });
    }


    public static void main(String[] args) {
        testMapOne();
    }
}
