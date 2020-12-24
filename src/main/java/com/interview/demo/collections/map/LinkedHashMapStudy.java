package com.interview.demo.collections.map;

import java.util.LinkedHashMap;

/**
 * 双链表 + hashmap
 * 不是线程安全的
 */
public class LinkedHashMapStudy {


    public static void testLinkedHashMap(){

        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("aaa", "aaa");
        linkedHashMap.put("kkk", "kkk");
        linkedHashMap.put("111", "111");

        linkedHashMap.keySet().stream().forEach(item -> {
            System.out.println(item + ":" + linkedHashMap.get(item));
        });

    }

    public static void main(String[] args) {
        testLinkedHashMap();
    }

}
