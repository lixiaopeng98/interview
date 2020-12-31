package com.interview.demo.redis.datastructure;

/**
 * redis 的 九大数据结构 以及 实现的数据结构
 * sds、双端链表、字典、kipelist、ziplist、
 *
 * 又引申出个 淘汰策略
 */
public class DataStructure{

    /**
     * String
     * hash
     * set
     * zset
     * list
     * bitmap
     * GEO
     * GEOHASH
     * Streams
     */
    /**
     *  String
     *  数据结构 int、raw、embstr
     *  SDS
     *  sds 「简单动态字符串」，对于SDS中的定义在Redis的源码中有的三个属性int len、int free、char buf[]。
     *      len保存了字符串的长度
     *      free表示buf数组中未使用的字节数量
     *      buf数组则是保存字符串的每一个字符元素。
     */
    /**
     * hash
     * 数据结构为 hashtable、ziplist
     * 其中hashtable的存储方式key是String类型的，value也是以key value的形式进行存储。
     * 赋值数据:
     * 127.0.0.1:6379>  HMSET runoobkey name "redis tutorial" description "redis basic commands for caching" likes 20 visitors 23000
     * OK
     * 127.0.0.1:6379>  HGETALL runoobkey
     * 1) "name"
     * 2) "redis tutorial"
     * 3) "description"
     * 4) "redis basic commands for caching"
     * 5) "likes"
     * 6) "20"
     * 7) "visitors"
     * 8) "23000"
     *
     */
    /**
     *
     */
    /**
     *
     */


    /**
     * 减少修改字符串时带来的内存重分配次数
     * 空间预分配
     * 惰性空间释放
     */
}
