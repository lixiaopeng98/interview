package com.interview.demo.redis.datastructure;

/**
 * @describe: redis 跳表 skip list
 * @author: lxp
 * @date: 2020/12/30 20:07
 */
public class SkipList {

    /**
     * 知道一点 跳表的概念 只写个 总结吧 不过多的深究了
     * 1. redis 的 zset 底层实现之一 就是跳表
     * 2. redis 的跳跃表实现由 zskiplist 和 zskiplistNode 两个结构组成,其中zskiplist用于保存
     * 跳跃表信息(比如表头节点、表尾节点、长度)，而zskiplistNode则用于表示跳跃表节点
     * 3. 每个跳跃表节点的最高层都是1至32之间的随机数
     * 4. 在用一个跳跃表中，多个节点可以包含相同的分值，但每个节点的成员对象必须是唯一的
     * 5. 跳跃表中的节点按照分值大小进行排序，当分值相同时，节点按照成员对象的大小进行排序
     */
}
