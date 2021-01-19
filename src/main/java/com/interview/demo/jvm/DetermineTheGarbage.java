package com.interview.demo.jvm;

/**
 * @describe: 确定垃圾
 * @author: lxp
 * @date: 2021/1/18 10:37
 */
public class DetermineTheGarbage {

    /**
     * JVM 是如何确定垃圾的
     * 1. 引用计数法
     *      一个对象如果没有任何与之关联的引用，即他们的引用计数都不为0，则说明对象不太可能
     *      再被用到，那么这个对象就是可回收对象
     * 2. 可达性分析
     *
     */
}
