package com.interview.demo.redis.datastructure;

/**
 * @describe: redis 字典学习
 * @author: lxp
 * @date: 2020/12/30 16:17
 */
public class DictStudy {

    /**
     * 什么是redis 的字典
     * 字典，又称为符号表(symbol table)，关联数组(associative array)或映射(map)，是一种用于保存键值对(key-value pair)的抽象数据结构。
     *
     * redis的字典底层实现是哈希表
     *
     * dict 字典
     *  dictType type;  指向dictType
     *  privdata;       保存了特定函数
     *  ht;             指向哈希表的一个数组 一般是h[0],h[1]
     *  rehashidx;      rehash 时候用 一般没有rehash时是 -1
     *
     * dictht 哈希表
     *  table[];    指向 dictEntry
     *  size;       hash表的大小 table的大小
     *  sizemask;   属性的值总是等于size - 1; 这个和hash值决定 键应该放在哪个 索引上
     *  used;       hash表已有数据的大小
     *
     * dictEntity   哈希表节点
     *   key;       key值
     *   v;         value值
     *   next;      指向下一个属性
     */

    /**
     * redis 计算哈希值 和索引值得方法
     *
     * 使用字典设置的哈希函数，计算键key的哈希值
     * hash = dict -> type -> hashFunction(key)
     *
     * 使用哈希表的 sizemask 属性和哈希值，计算出索引值
     * 根据情况不同，ht[x]可以是ht[0]或者ht[1]
     * index = hash & dict -> ht[x].sizemask;
     */

    /**
     * hash 解决冲突
     * 使用方法为 链地址法
     * 链地址法: 使用单向链表 链接同一索引上的多个节点
     *          即: 两个key 解析出来的index 为同一个的时候，用一个单向链表链接起来
     */
    /**
     * redis dict/字典 的 rehash 扩容、降容
     * 满足以下两个其一就会扩容:
     * 1. 服务器目前没有在执行BGSAVE 命令或者 BGREWRITEAOF 命令, 并且hash表的负载因子大于等于1;
     * 2. 服务器目前正在执行BGSAVE 命令或者 BGREWRITEAOF 命令, 并且hash表的负载因子大于等于5;
     * 负载因子 = 哈希表已保存节点数量 / 哈希表大小
     * load_factor = ht[0].user / ht[0].size
     */
    /**
     * 一. 扩容步骤
     * 大概扩容步骤就是 把字典的 ht[0] 转移到 ht[1]
     * 1. 计算ht[1] 的 大小  第一个大于等于ht[0].used*2  即: 两倍
     * 2. 根据 ht[1] 重新计算 ht[0]数据的索引值 然后rehash到 ht[1] 上
     * 3. 释放掉 ht[0], 把ht[1] 变成 ht[0], 重新创建一个ht[1],为下一次扩容准备
     *
     * 二. 渐进式扩容法
     * 大概扩容步骤就是
     * 1. 同事持有 两个 ht表 ht[0]、ht[1]
     * 2. 把字典里的 rehashidx 改为 0 表示开始扩容
     * 3. 把ht[0] 上的数据 一个个 转移到 ht[1] 上，同时只允许 ht[0] 修改，删除，查找，不允许新增，保证ht[0] 只会减不会增，
     *    转移成功一次后 rehashidx + 1，
     * 4. 数据转移成功后 rehashidx 会变成 -1，同时 释放ht[0], 接下来和正常扩容流程一直
     */


}
