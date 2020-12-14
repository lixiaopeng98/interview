package com.interview.demo.redis;

import java.util.HashMap;

public class TestRLock {

    /**
     * 一. 缓存穿透：key对应的数据在数据源并不存在，每次针对此key的请求从缓存获取不到，请求都会到数据源，从而可能压垮数据源。
     * 比如用一个不存在的用户id获取用户信息，不论缓存还是数据库都没有，若黑客利用此漏洞进行攻击可能压垮数据库。
     *
     *      1. 最常见的则是采用布隆过滤器，将所有可能存在的数据哈希到一个足够大的bitmap 中，一个一定不存在的数据会被这个bitmap 拦截掉，从而避免了对底层存储系统的查询压力。
     *      2. 另外也有一个更为简单粗暴的方法，如果一个查询返回的数据为空（不管是数据不存在，还是系统故障），我们仍然把这个空结果进行缓存，但它的过期时间会很短，最长不超过五分钟。
     *      通过这个直接设置的默认值存放到缓存，这样第二次到缓冲中获取就有值了，而不会继续访问数据库。
     *
     * 二. 缓存击穿：key对应的数据存在，但在redis中过期，此时若有大量并发请求过来，这些请求发现缓存过期一般都会从后端DB加载数据并回设到缓存，
     * 这个时候大并发的请求可能会瞬间把后端DB压垮。
     *
     *      1.业界比较常用的做法，是使用mutex。简单地来说，就是在缓存失效的时候（判断拿出来的值为空），不是立即去load db，而是先使用缓存工具的某些带成功操作返回值的操作（比如Redis的SETNX或者Memcache的ADD）去set一个mutex key，当操作返回成功时，再进行load db的操作并回设缓存；否则，就重试整个get缓存的方法。
     *
     * 三. 缓存雪崩：当缓存服务器重启或者大量缓存集中在某一个时间段失效，这样在失效的时候，也会给后端系统(比如DB)带来很大压力
     *      1. 一般并发量不是特别多的时候，使用最多的解决方案是加锁排队。
     *      2. 给每一个缓存数据增加相应的缓存标记，记录缓存的是否失效，如果缓存标记失效，则更新数据缓存。
     *      3. 为key 设置不同的缓存失效时间。
     */


    public void addLock(){

    }

    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("aaa", "aaa");
        hashMap.put("bbb", "bbb");
        hashMap.put("111", "111");



        hashMap.keySet().stream().forEach(item -> {
            System.out.println(hashMap.get(item).toString());
        });
    }
}
