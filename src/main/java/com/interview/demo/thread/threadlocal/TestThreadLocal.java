package com.interview.demo.thread.threadlocal;

import java.util.HashMap;

public class TestThreadLocal {

    private static final ThreadLocal threadLocal = new ThreadLocal();

    /**
     * ThreadLocal 是什么？
     * ThreadLocal 是一个本地线程副本变量工具类。主要用于将私有线程和该线程存放的副本对象做一个映射，
     * 各个线程之间的变量互不干扰，在高并发场景下，可以实现无状态的调用，适用于各个线程不共享变量值的操作
     */
    /**
     * ThreadLocal 工作原理是什么？
     * ThreadLocal 原理：每个线程的内部都维护了一个 ThreadLocalMap，它是一个 Map（key,value）数据格式，
     * key 是一个弱引用，也就是 ThreadLocal 本身，而 value 存的是线程变量的值。
     * 也就是说 ThreadLocal 本身并不存储线程的变量值，它只是一个工具，用来维护线程内部的 Map，帮助存和取变量
     */
    /**
     * ThreadLocal 如何解决 Hash 冲突？
     * 与 HashMap 不同，ThreadLocalMap 结构非常简单，没有 next 引用，也就是说 ThreadLocalMap 中解决 Hash
     * 冲突的方式并非链表的方式，而是采用线性探测的方式。所谓线性探测，就是根据初始 key 的 hashcode 值确定元素在 table 数组中的位置，
     * 如果发现这个位置上已经被其他的 key 值占用，则利用固定的算法寻找一定步长的下个位置，依次判断，直至找到能够存放的位置。
     */
    /**
     * ThreadLocal 的内存泄露是怎么回事？
     * ThreadLocal 在 ThreadLocalMap 中是以一个弱引用身份被 Entry 中的 Key 引用的，因此如果 ThreadLocal 没有外部强引用来引用它，
     * 那么 ThreadLocal 会在下次 JVM 垃圾收集时被回收。这个时候 Entry 中的 key 已经被回收，但是 value 又是一强引用不会被垃圾收集器回收，
     * 这样 ThreadLocal 的线程如果一直持续运行，value 就一直得不到回收，这样就会发生内存泄露。
     */
    /**
     * 为什么 ThreadLocalMap 的 key 是弱引用？
     * 我们知道 ThreadLocalMap 中的 key 是弱引用，而 value 是强引用才会导致内存泄露的问题，至于为什么要这样设计，这样分为两种情况来讨论：
     *
     * key 使用强引用：这样会导致一个问题，引用的 ThreadLocal 的对象被回收了，但是 ThreadLocalMap 还持有 ThreadLocal 的强引用，
     * 如果没有手动删除，ThreadLocal 不会被回收，则会导致内存泄漏。
     * key 使用弱引用：这样的话，引用的 ThreadLocal 的对象被回收了，由于 ThreadLocalMap 持有 ThreadLocal 的弱引用，即使没有手动删除，
     * ThreadLocal 也会被回收。value 在下一次 ThreadLocalMap 调用 set、get、remove 的时候会被清除。
     * 比较以上两种情况，我们可以发现：由于 ThreadLocalMap 的生命周期跟 Thread 一样长，如果都没有手动删除对应 key，都会导致内存泄漏，
     * 但是使用弱引用可以多一层保障，弱引用 ThreadLocal 不会内存泄漏，对应的 value 在下一次 ThreadLocalMap
     * 调用 set、get、remove 的时候被清除，算是最优的解决方案。
     */
    public void getAndSet(){
        threadLocal.set("aaa");

        "aaa".hashCode();

        threadLocal.get();
        int cc = 10;
        for (int i = 0; i < cc; i++) {

        }

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("aa","");
    }
}
