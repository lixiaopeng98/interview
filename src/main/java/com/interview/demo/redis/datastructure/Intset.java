package com.interview.demo.redis.datastructure;

/**
 * @describe: redis 整数集合
 * @author: lxp
 * @date: 2020/12/31 11:16
 */
public class Intset {

    /**
     * 没啥可看的
     *
     * 1. 整数集合是集合键的底层实现之一
     * 2. 整数集合的底层实现为数组，这个数组以有序、无重复的方式保存集合元素，
     *      再有需要时，程序会根据新添加元素的类型，改变这个数组的类型
     * 3. 升级操作为整数集合带来了操作上的灵活性，并且尽可能的节约了内存
     * 4. 整数集合只支持升级操作，不支持降级操作
     */
}
