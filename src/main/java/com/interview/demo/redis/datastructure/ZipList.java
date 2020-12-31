package com.interview.demo.redis.datastructure;

/**
 * @describe: redis 压缩列表
 * @author: lxp
 * @date: 2020/12/31 11:21
 */
public class ZipList {

    /**
     * 压缩列表是redis 为了节约内存而开发的顺序型数据结构
     * 压缩列表被用作列表键和哈希键的底层实现之一
     * 压缩列表可以包含多个节点，每个节点可以保存一个字节数组或者整数值
     * 添加新节点到压缩列表，或者从压缩列表中删除节点，可能会引发连锁更新操作，但这种操作出现的几率不高
     */
}
