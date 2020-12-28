package com.interview.demo.jvm;

/**
 * JVM 学习
 */
public class JvmStudy {

    /**
     *
     堆从gc 的角度看
     新生代  老年代  永久代/元数据
     新生代又分为
     eden from to
     minorGC 也是复制GC
     1.把eden 和 from 区域中 活跃的对象 放到 to中
     2.把eden 和 from 区域中 剩下的数据删除掉
     3.把to 和 from 互换 原来的to 变成 下一次gc的 from

     老年代是标记清楚算法 majorGC
     1. 标记活跃的数据
     2. 删除没有标记的数据


     如何确定是否是垃圾
     1.引用计数法--如果一个对象 没有任何与之关联的引用 则说明该对象不太可能会被用到 那么这个对象就会被回收
     2.可达性分析--
     */
    public static void handlerJvm(){

    }

}
