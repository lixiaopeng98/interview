package com.interview.demo.collections.map;

import java.util.WeakHashMap;

/**
 * 这个玩意 也是 HashMap
 *
 * 底层的 Entry  继承了WeakReference 是哥弱引用  gc 会给会收掉
 */
public class WeakHashMapStudy {

    public static void testWeakHashMap(){
        WeakHashMap<String, Object> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("aaa", "aaa");
    }

}
