package com.interview.demo.collections.map;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 跳表
 * 什么 什么是跳表？#{link https://blog.csdn.net/sunxianghuang/article/details/52221913}
 *
 * ConcurrentSkipListMap 支持更高的并发。ConcurrentSkipListMap 的存取时间是log（N），
 * 和线程数几乎无关。也就是说在数据量一定的情况下，并发的线程越多，ConcurrentSkipListMap越能体现出他的优势。
 *
 * ConcurrentSkipListMap 的key是有序的
 */
public class ConcurrentSkipListMapStudy {

    /**
     * 二分查找要求元素可以随机访问，所以决定了需要把元素存储在连续内存。这样查找确实很快，但是插入和删除元素的时候，
     * 为了保证元素的有序性，就需要大量的移动元素了。
     * 如果需要的是一个能够进行二分查找，又能快速添加和删除元素的数据结构，首先就是二叉查找树，二叉查找树在最坏情况下可能变成一个链表。
     * 于是，就出现了平衡二叉树，根据平衡算法的不同有AVL树，B-Tree，B+Tree，红黑树等，
     * 但是AVL树实现起来比较复杂，平衡操作较难理解，这时候就可以用SkipList跳跃表结构
     */
    public static void testSkipList() {

        ConcurrentSkipListMap<String, Object> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        concurrentSkipListMap.put("aaa", "aaa");

    }

}
